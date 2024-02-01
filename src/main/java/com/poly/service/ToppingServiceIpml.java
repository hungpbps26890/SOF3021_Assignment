package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.ToppingDAO;

@Service
public class ToppingServiceIpml implements ToppingService{
	@Autowired
	ToppingDAO toppingDAO;
}
