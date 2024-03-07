package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.dao.DrinkDAO;
import com.poly.entity.Category;
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

	@Override
	public List<Drink> findByCategory(Category category) {
		return drinkDAO.findByCategory(category);
	}

	@Override
	public List<Drink> findRelatedDrink(Category category, Integer id, Limit limit) {
		return drinkDAO.findRelatedDrink(category, id, limit);
	}

	@Override
	public List<Drink> findMore(Limit limit) {
		return drinkDAO.findMore(limit);
	}

	@Override
	public List<Drink> findByCategoryAndActive(Category category, Boolean active) {
		// TODO Auto-generated method stub
		return drinkDAO.findByCategoryAndActive(category, active);
	}

	@Override
	public Page<Drink> findByActive(Boolean active, Pageable pageable) {
		// TODO Auto-generated method stub
		return drinkDAO.findByActive(active, pageable);
	}

	public List<Drink> findByActive(boolean active) {
		// TODO Auto-generated method stub
		return drinkDAO.findByActive(active);
	}

	@Override
	public List<Drink> findRelatedDrink(Category category, Integer id, Boolean active, Limit limit) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
