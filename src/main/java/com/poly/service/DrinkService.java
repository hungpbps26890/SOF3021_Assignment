package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Category;
import com.poly.entity.Drink;

public interface DrinkService {

	void delete(Drink entity);

	void deleteById(Integer id);

	Drink findById(Integer id);

	List<Drink> findAll();

	Page<Drink> findAll(Pageable pageable);
	
	Page<Drink> findByActive(Boolean active, Pageable pageable);

	List<Drink> findAll(Sort sort);

	Drink save(Drink entity);
	
	List<Drink> findByCategory(Category category);
	
	List<Drink> findByActive(boolean active);
	
	List<Drink> findRelatedDrink(Category category, Integer id, Limit limit);
	
	List<Drink> findMore(Limit limit);
	
	List<Drink> findByCategoryAndActive(Category category, Boolean active);

}
