package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.DrinkDAO;
import com.poly.entity.Drink;
import com.poly.model.CartItem;
import com.poly.service.CartService;

@Controller
public class CartController {

	@Autowired
	DrinkDAO drinkDAO;

	@Autowired
	CartService cartService;

	@GetMapping("cart")
	public String getCart(Model model) {

		model.addAttribute("cart", cartService.getItems());
		model.addAttribute("amount", cartService.getAmount());
		model.addAttribute("count", cartService.getCount());

		return "user/cart";
	}

	@GetMapping("cart/add/{id}")
	public String addCartItem(@PathVariable("id") Integer id) {
		
		Drink drink = drinkDAO.findById(id).get();
		
		if (drink != null) {
			CartItem cartItem = new CartItem();
			
			cartItem.setId(drink.getId());
			cartItem.setName(drink.getName());
			cartItem.setPrice(drink.getPrice());
			cartItem.setImage(drink.getDrinkImage());
			
			cartService.add(cartItem);
		}
		
		return "redirect:/cart";
	}
	
	@GetMapping("cart/delete/{id}")
	public String deleteCartItem(@PathVariable("id") Integer id) {
		cartService.remove(id);
		return "redirect:/cart";
	}
	
	@GetMapping("cart/clear")
	public String clearCart() {
		cartService.clear();
		return "redirect:/cart";
	}
	
	@PostMapping("cart/update")
	public String updateCartItem(@RequestParam("id") Integer id, @RequestParam("quantity") Integer quantity) {
		cartService.update(id, quantity);
		return "redirect:/cart";
	}
}
