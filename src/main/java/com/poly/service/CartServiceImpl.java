package com.poly.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.model.CartItem;

@SessionScope
@Service
public class CartServiceImpl implements CartService {

	Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	
	@Override
	public CartItem add(CartItem cartItem) {
		CartItem existedCartItem = map.get(cartItem.getId());

		if (existedCartItem == null) {
			map.put(cartItem.getId(), cartItem);

			return cartItem;
		} else {
			existedCartItem.setQuantity(existedCartItem.getQuantity() + 1);
		}

		return existedCartItem;
	}

	@Override
	public void remove(Integer id) {
		map.remove(id);
		
	}

	@Override
	public void update(Integer id, Integer quantity) {
		CartItem cartItem = map.get(id);
		cartItem.setQuantity(quantity);
	}

	@Override
	public void clear() {
		map.clear();
		
	}

	@Override
	public int getCount() {
		return map.values().stream().mapToInt(cartItem -> cartItem.getQuantity()).sum();
	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(cartItem -> cartItem.getPrice() * cartItem.getQuantity()).sum();
	}

	@Override
	public Collection<CartItem> getItems() {
		return map.values();
	}

}
