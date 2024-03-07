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
	
<<<<<<< HEAD
	List<Drink> findAllByActive(Boolean active, Limit limit);
=======
	List<Drink> findByActive(Boolean active);
	
	Page<Drink> findByActive(Boolean active, Pageable pageable);
>>>>>>> cc4c404d445e3b096a6b692f09cc21e933df0b3e
	
	@Query("SELECT d FROM Drink d WHERE d.category = ?1 AND d.id <> ?2 AND d.active = ?3")
	List<Drink> findRelatedDrink(Category category, Integer id, Boolean active, Limit limit);
	
	@Query("SELECT d FROM Drink d")
	List<Drink> findMore(Limit limit);
	
	@Query("SELECT d FROM Drink d WHERE d.name LIKE %?1% OR d.description LIKE %?1% OR d.category.name LIKE %?1%")
	Page<Drink> searchByKeyword(String keyword, Pageable pageable);
}
