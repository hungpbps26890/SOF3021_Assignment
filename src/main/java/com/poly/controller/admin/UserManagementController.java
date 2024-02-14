package com.poly.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poly.entity.User;
import com.poly.service.UserService;

@Controller
public class UserManagementController {

	@Autowired
	UserService userService;
	
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

}
