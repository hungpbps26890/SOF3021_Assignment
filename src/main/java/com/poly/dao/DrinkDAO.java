package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Drink;

public interface DrinkDAO extends JpaRepository<Drink, Integer> {

}
