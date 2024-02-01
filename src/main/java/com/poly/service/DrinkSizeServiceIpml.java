package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.DrinkSizeDAO;

@Service
public class DrinkSizeServiceIpml implements DrinkSizeService{
	@Autowired
	DrinkSizeDAO drinkSizeDAO;
}
