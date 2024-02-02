package com.poly.service;

import java.util.List;

import com.poly.entity.Order;
import com.poly.entity.ShoppingCart;

public interface OrderService {

	void saveOrder(ShoppingCart cart);
	
	void saveOrder(ShoppingCart cart, Order order);
	
	void cancelOrder(Long id);
	
	List<Order> findAllByUsername(String username);
}
