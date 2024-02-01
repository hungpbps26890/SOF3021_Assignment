package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.poly.dao.DrinkDAO;
import com.poly.entity.Drink;

@Controller
public class DrinkController {

	@Autowired
	DrinkDAO drinkDAO;
	
	@GetMapping("drink/{id}")
	public String getProductDetail(@PathVariable("id") Integer id, Model model) {
		
		Drink drink = drinkDAO.findById(id).get();
		model.addAttribute("drink", drink);
		
		return "user/detail";
	}
	
	@ModelAttribute("drinks")
	public List<Drink> getDrinks() {
		return drinkDAO.findAll();
	}
}
