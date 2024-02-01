package com.poly.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Category;

import jakarta.validation.Valid;

@Controller
public class CategoryManagementController {

	@Autowired
	CategoryDAO categoryDAO;
	
	boolean edit = false;

	@GetMapping("admin/category")
	public String getCategoryManagement(Model model) {

		Category category = new Category();
		model.addAttribute("category", category);
		
		edit = false;
		model.addAttribute("edit", edit);

		return "admin/category-management";
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.findAll();
	}

	@PostMapping("admin/category")
	public String save(Model model, @Valid @ModelAttribute("category") Category category, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println(result.toString());
		} else {
			
			if (category.getId() == null) {
				model.addAttribute("message", "Add new category successfully");
			} else {
				model.addAttribute("message", "Update category successfully");
			}
			
			categoryDAO.saveAndFlush(category);
			
			category = new Category();
			model.addAttribute("category", category);
		}
		
		List<Category> categories = categoryDAO.findAll();
		model.addAttribute("categories", categories);
		
		edit = false;
		model.addAttribute("edit", edit);
		
		return "admin/category-management";
	}

	@GetMapping(value = "admin/category", params = "btnEdit")
	public String edit(Model model, @RequestParam("id") Integer id) {
		Category category = categoryDAO.findById(id).get();
		model.addAttribute("category", category);
		
		edit = true;
		model.addAttribute("edit", edit);

		return "/admin/category-management";
	}

	@PostMapping("admin/category/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {

		categoryDAO.deleteById(id);

		return "redirect:/admin/category";
	}

	@GetMapping(value = "admin/category", params = "btnDel")
	public String deleteInline(@RequestParam("id") Integer id, Model model) {
		categoryDAO.deleteById(id);

		return "redirect:/admin/category";
	}
}
