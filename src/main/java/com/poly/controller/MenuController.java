package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.poly.dao.CategoryDAO;
import com.poly.dao.DrinkDAO;
import com.poly.entity.Category;
import com.poly.entity.Drink;

@Controller
public class MenuController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	DrinkDAO drinkDAO;
	
	@GetMapping("menu")
	public String getMenu() {
		
		return "user/menu";
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.findAll();
	}
	
	@ModelAttribute("drinks")
	public List<Drink> getDrinks() {
		return drinkDAO.findAll();
	}
}
