package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.dao.UserDAO;
import com.poly.entity.User;
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
	UserDAO userDAO;

	@GetMapping("account/login")
	public String getLogin(Model model) {
		
		Cookie username = cookieService.get("cookieUsername");
		User user = new User();
		
		if (username != null) {
			user = userDAO.findById(username.getValue()).get();
		}
		
		model.addAttribute("user", user);
		
		return "user/login";
	}
	
	@PostMapping("account/login")
	public String login(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {
	
		if (result.hasFieldErrors("username") || result.hasFieldErrors("password")) {
			System.out.println("Has errors: " + result.toString());
		} else {
			String username = user.getUsername();
			String password = user.getPassword();
			boolean remember = paramService.getBoolean("remember", false);
			
			try {
				
				user = userDAO.findById(username).get();
				
				if (user != null && user.getPassword().equals(password)) {
					if (remember == true) {
						cookieService.create("cookieUsername", username, 10);
						cookieService.create("cookiePassword", password, 10);
					} else {
						cookieService.remove("cookieUsername");
						cookieService.remove("cookiePassword");
					}

					sessionService.setAttribute("currentUser", user);

					String uri = sessionService.getAttribute("security-uri");

					if (uri != null && !uri.equals("/account/logout")) {
						return "redirect:" + uri;
					}
					
					if (user.getAdmin()) {
						return "redirect:/admin/drink";
					}

					return "redirect:/home";
				} else {
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
			
			User updatedUser = userDAO.findById(currentUser.getUsername()).get();
			
			updatedUser.setFirstName(user.getFirstName());
			updatedUser.setLastName(user.getLastName());
			updatedUser.setEmail(user.getEmail());

			userDAO.save(updatedUser);

			model.addAttribute("message", "Update profile successfully!");

			sessionService.setAttribute("currentUser", updatedUser);
		}
		
		return "user/profile";
	}
}
