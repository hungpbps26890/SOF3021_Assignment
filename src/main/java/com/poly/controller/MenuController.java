package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.poly.entity.Category;
import com.poly.entity.Drink;
import com.poly.service.CategoryService;
import com.poly.service.DrinkService;

@Controller
public class MenuController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	DrinkService drinkService;
	
	@GetMapping("menu")
	public String getMenu() {
		
		return "user/menu";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryService.findAll();
	}
	
	@ModelAttribute("drinks")
	public List<Drink> getDrinks() {
		return drinkService.findAll();
	}
}
