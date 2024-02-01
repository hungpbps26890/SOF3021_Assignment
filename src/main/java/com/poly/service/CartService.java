package com.poly.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.model.CartItem;

@SessionScope
@Service
public interface CartService {
	
	CartItem add(CartItem cartItem);
	
	void remove(Integer id);
	
	void update(Integer id, Integer quantity);
	
	void clear();

	int getCount();

	double getAmount();

	Collection<CartItem> getItems();
}
