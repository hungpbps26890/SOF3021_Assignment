package com.poly.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.User;
import com.poly.service.ShoppingCartService;
import com.poly.service.UserService;
import com.poly.utils.CookieService;
import com.poly.utils.ParamService;
import com.poly.utils.SessionService;

import jakarta.servlet.http.Cookie;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	ParamService paramService;

	@Autowired
	CookieService cookieService;

	@Autowired
	SessionService sessionService;

	@Autowired
	UserService userService;

	@Autowired
	ShoppingCartService cartService;

	@GetMapping("/account/login")
	public String getLogin(Model model) {

		Cookie username = cookieService.get("cookieUsername");
		User user = new User();

		if (username != null) {
			user = userService.findById(username.getValue());
		}

		model.addAttribute("user", user);

		return "user/login";
	}

	@PostMapping("/account/login")
	public String login(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {

		if (result.hasFieldErrors("username") || result.hasFieldErrors("password")) {
			System.out.println("Has errors: " + result.toString());
		} else {
			String username = user.getUsername();
			String password = user.getPassword();
			boolean remember = paramService.getBoolean("remember", false);

			try {

				user = userService.findById(username);

				if (user != null && user.getPassword().equals(password)) {
					if (remember == true) {
						cookieService.create("cookieUsername", username, 10);
						cookieService.create("cookiePassword", password, 10);
					} else {
						cookieService.remove("cookieUsername");
						cookieService.remove("cookiePassword");
					}
					
					if (user.getCart() == null) {
						cartService.createNewShoppingcart(user);
					}
					
					sessionService.setAttribute("currentUser", user);

					String uri = sessionService.getAttribute("security-uri");

					if (uri != null && !uri.equals("/account/logout")) {
						return "redirect:" + uri;
					}
					if(user.getActive()) {
						if (user.getAdmin()) {
							return "redirect:/admin/drink";
						}else {
							return "redirect:/home";
						}
					}else {
						sessionService.removeAttribute("currentUser");
						model.addAttribute("mess", "Your account has been locked, please contact your Admin (admin@gmail.com) to open an account!");
					}
				}else {
					throw new Exception();
				}

			} catch (Exception e) {
				model.addAttribute("message", "Username or password is invalid!");
			}
		}

		return "user/login";
	}

	@GetMapping("account/logout")
	public String logout() {
		sessionService.removeAttribute("currentUser");
		return "redirect:/home";
	}

	@GetMapping("account/profile")
	public String getProfile(Model model) {

		User currentUser = sessionService.getAttribute("currentUser");
		model.addAttribute("user", currentUser);

		return "user/profile";
	}

	@PostMapping("account/profile")
	public String updateProfile(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {

		if (result.hasFieldErrors("username") || result.hasFieldErrors("firstname") || result.hasFieldErrors("lastName")
				|| result.hasFieldErrors("email")) {
			System.out.println("Has errors: " + result.toString());
		} else {
			User currentUser = sessionService.getAttribute("currentUser");

			User updatedUser = userService.findById(currentUser.getUsername());

			updatedUser.setFirstName(user.getFirstName());
			updatedUser.setLastName(user.getLastName());
			updatedUser.setEmail(user.getEmail());

			userService.save(updatedUser);

			model.addAttribute("message", "Update profile successfully!");

			sessionService.setAttribute("currentUser", updatedUser);
		}

		return "user/profile";
	}

	@GetMapping("account/register")
	public String getRegister(Model model) {
		model.addAttribute("registerUser", new User());

		return "user/register";
	}

	@PostMapping("account/register")
	public String register(Model model, @Valid @ModelAttribute("registerUser") User registerUser, BindingResult result,
			@RequestParam("confirmedPassword") String confirmedPassword) {

		if (result.hasErrors() && confirmedPassword.equals("")) {
			model.addAttribute("confirmedPasswordErrorMessage", "Please enter Confirmed Password");
		} else {

			if (registerUser.getPassword().equals(confirmedPassword)) {
				try {
					registerUser = userService.save(registerUser);

					cartService.createNewShoppingcart(registerUser);

					sessionService.setAttribute("currentUser", registerUser);

					return "redirect:/home";
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("confirmedPassword", confirmedPassword);
					model.addAttribute("errorMessage", "Username is already registerd, please choose another Username");
				}

			} else {
				model.addAttribute("confirmedPassword", confirmedPassword);
				model.addAttribute("confirmedPasswordErrorMessage", "Confirmed passowrd is invalid");
			}

		}

		return "user/register";
	}

	@GetMapping("acount/change-password")
	public String getChangePassword(Model model) {
		User user = sessionService.getAttribute("currentUser");
		model.addAttribute("user", user);
		return "user/change-password";
	}

	@PostMapping("account/change-password")
	public String changePassword(Model model, @ModelAttribute("user") User user,
			@RequestParam("password") String password, @RequestParam("newPassword") String newPassword,
			@RequestParam("confirmedPassword") String confirmedPassword) {

		model.addAttribute("password", password);
		model.addAttribute("newPassword", newPassword);
		model.addAttribute("confirmedPassword", confirmedPassword);

		if (password.equals("")) {
			model.addAttribute("passwordErrorMessage", "Please enter Password");
		} else if (newPassword.equals("")) {
			model.addAttribute("newPasswordErrorMessage", "Please enter New Password");
		} else if (confirmedPassword.equals("")) {
			model.addAttribute("confirmedPasswordErrorMessage", "Please enter Confirmed Password");
		} else {
			user = userService.findById(user.getUsername());
			
			if (user.getPassword().equals(password)) {

				if (newPassword.equals(confirmedPassword)) {
					try {
						user.setPassword(newPassword);

						user = userService.save(user);

						sessionService.setAttribute("currentUser", user);
						
						model.addAttribute("password", null);
						model.addAttribute("newPassword", null);
						model.addAttribute("confirmedPassword", null);

						model.addAttribute("message", "Change Password successfully");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {

					model.addAttribute("confirmedPasswordErrorMessage", "Confirmed password is invalid");
				}

			} else {
				model.addAttribute("passwordErrorMessage", "Password is invalid");
			}
		}

		return "user/change-password";
	}
	
}
