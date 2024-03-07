package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Category;
import com.poly.entity.Drink;

public interface DrinkDAO extends JpaRepository<Drink, Integer> {

	List<Drink> findByCategory(Category category);
	
	List<Drink> findByCategoryAndActive(Category category, Boolean active);
	

	List<Drink> findAllByActive(Boolean active, Limit limit);

	List<Drink> findByActive(Boolean active);
	
	Page<Drink> findByActive(Boolean active, Pageable pageable);
	
	@Query("SELECT d FROM Drink d WHERE d.category = ?1 AND d.id <> ?2")
	List<Drink> findRelatedDrink(Category category, Integer id, Limit limit);
	
	@Query("SELECT d FROM Drink d")
	List<Drink> findMore(Limit limit);
}
