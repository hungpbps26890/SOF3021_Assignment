package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.entity.Drink;
import com.poly.service.DrinkService;

@Controller
public class DrinkController {

	@Autowired
	DrinkService drinkService;
	
	@GetMapping("drink/{id}")
	public String getProductDetail(@PathVariable("id") Integer id, Model model) {
		
		Drink drink = drinkService.findById(id);
		model.addAttribute("drink", drink);
		
		return "user/detail";
	}
	
	@ModelAttribute("drinks")
	public List<Drink> getDrinks() {
		return drinkService.findAll();
	}
}
