package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.poly.dao.DrinkDAO;
import com.poly.entity.Drink;
import com.poly.utils.SessionService;

@Controller
public class HomeController {
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	DrinkDAO drinkDAO;

	@GetMapping("home")
	public String getIndex() {
		
		sessionService.setAttribute("security-uri", null);
		
		return "user/index";
	}
	
	@ModelAttribute("drinks")
	public List<Drink> getDrinks() {
		return drinkDAO.findAll();
	}
	
}
