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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.poly.dao.CategoryDAO;
import com.poly.dao.DrinkDAO;
import com.poly.entity.Category;
import com.poly.entity.Drink;
import com.poly.utils.UploadService;

import jakarta.validation.Valid;

@Controller
public class DrinkManagementController {

	@Autowired
	DrinkDAO drinkDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	UploadService uploadService;

	boolean edit = false;

	@GetMapping("admin/drink")
	public String getDrinkManagement(Model model) {

		Drink drink = new Drink();
		model.addAttribute("drink", drink);

		List<Drink> drinks = drinkDAO.findAll();
		model.addAttribute("drinks", drinks);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/drink-management";
	}
	
	@ModelAttribute("drinks")
	public List<Drink> getDrinks() {
		return drinkDAO.findAll();
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.findAll();
	}

	@PostMapping("admin/drink")
	public String save(Model model, @Valid @ModelAttribute("drink") Drink drink, BindingResult result,
			@RequestPart("photo") MultipartFile photo) {

		if (result.hasErrors() || photo.isEmpty()) {
			model.addAttribute("errorFile", "Please choose Image");
		} else {

			String fileName = photo.getOriginalFilename();
			uploadService.save(photo, "/images/");
			drink.setDrinkImage(fileName);

			Category category = categoryDAO.findById(drink.getCategory().getId()).get();
			drink.setCategory(category);

			if (drink.getId() == null) {
				model.addAttribute("message", "Add new drink successfully");
			} else {
				model.addAttribute("message", "Update drink successfully");
			}

			drink = drinkDAO.save(drink);

			drink = new Drink();
			model.addAttribute("drink", drink);
		}

		List<Drink> drinks = drinkDAO.findAll();
		model.addAttribute("drinks", drinks);

		edit = false;
		model.addAttribute("edit", edit);

		return "admin/drink-management";
	}

	@GetMapping(value = "admin/drink", params = "btnEdit")
	public String edit(Model model, @RequestParam("id") Integer id) {
		Drink drink = drinkDAO.findById(id).get();
		model.addAttribute("drink", drink);

		edit = true;
		model.addAttribute("edit", edit);

		return "admin/drink-management";
	}

	@PostMapping("admin/delete/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		drinkDAO.deleteById(id);

		return "redirect:/admin/drink";
	}

	@GetMapping(value = "admin/drink", params = "btnDel")
	public String deleteInline(@RequestParam("id") Integer id) {
		drinkDAO.deleteById(id);

		return "redirect:/admin/drink";
	}

}
