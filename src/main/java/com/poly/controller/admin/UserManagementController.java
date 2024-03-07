package com.poly.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.UserDAO;
import com.poly.entity.User;
import com.poly.service.UserService;

import jakarta.validation.Valid;


@Controller
public class UserManagementController {

	@Autowired
	UserService userService;
	@Autowired
	UserDAO userDAO;
	
	boolean edit = false;
	
	@GetMapping("admin/user")
	public String getUserManagement(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/user-management";
	}
	
	@ModelAttribute("users")
	public List<User> getUser(){
		return userService.findAll();
	}
	
	@PostMapping("admin/user")
	public String save(Model model, @Valid @ModelAttribute("user") User user, 
			BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("message", result.toString());
			System.out.println(result.hasErrors());
		} else {
			if (user.getUsername() == null) {
				model.addAttribute("message", "Add new user successfully");
			} else {
				model.addAttribute("message", "Update user successfully");
			}

			user = userService.save(user);

			user = new User();
			model.addAttribute("user", user);
		}

		List<User> users = userService.findAll();
		model.addAttribute("users", users);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/user-management";
	}
	
	@GetMapping(value = "admin/user", params = "btnEdit")
	public String edit(Model model, @RequestParam("username") String username) {
		User user = userService.findById(username);
		model.addAttribute("user", user);

		edit = true;
		model.addAttribute("edit", edit);

		return "admin/user-management";
	}
	
	@PostMapping("admin/user/delete/{username}")
	public String delete(@PathVariable("username") String username) {
		userDAO.deleteById(username);

		return "redirect:/admin/user";
	}

	@GetMapping(value = "admin/user", params = "btnDel")
	public String deleteInline(@RequestParam("username") String username) {
		userService.deleteById(username);

		return "redirect:/admin/user";
	}
	
	@RequestMapping("/admin/user/page")
	public String page(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam("page") Optional<Integer> page ) {
		Pageable pageable = PageRequest.of(page.orElse(0), 2);
		model.addAttribute("page", userDAO.findAll(pageable));
		return "admin/user-management";
	}
}
