package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CategoryDAO;

@Service
public class CategoryServiceIpml implements CategoryService {
	@Autowired
	CategoryDAO categoryDAO;

}
