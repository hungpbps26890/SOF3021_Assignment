package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Category;
import com.poly.entity.Drink;

public interface DrinkDAO extends JpaRepository<Drink, Integer> {

	List<Drink> findByCategory(Category category);
}
