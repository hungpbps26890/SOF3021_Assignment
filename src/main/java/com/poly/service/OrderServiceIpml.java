package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderDAO;

@Service
public class OrderServiceIpml implements OrderService{
	@Autowired
	OrderDAO orderDAO;
}
