package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.dao.DrinkDAO;
import com.poly.entity.Drink;
import com.poly.service.DrinkService;

@Service
public class DrinkServiceIpml implements DrinkService{
	@Autowired
	DrinkDAO drinkDAO;

	@Override
	public Drink save(Drink entity) {
		return drinkDAO.save(entity);
	}

	@Override
	public List<Drink> findAll(Sort sort) {
		return drinkDAO.findAll(sort);
	}

	@Override
	public Page<Drink> findAll(Pageable pageable) {
		return drinkDAO.findAll(pageable);
	}

	@Override
	public List<Drink> findAll() {
		return drinkDAO.findAll();
	}

	@Override
	public Drink findById(Integer id) {
		return drinkDAO.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		Drink drink = findById(id);
		drink.setActive(false);
		save(drink);
	}

	@Override
	public void delete(Drink entity) {
		Drink drink = findById(entity.getId());
		drink.setActive(false);
		save(drink);

	}
	
	
}
