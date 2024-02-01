package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderDetailDAO;

@Service
public class OrderDetailServiceIpml implements OrderDetailService {
	@Autowired
	OrderDetailDAO orderDetailDAO;
}
