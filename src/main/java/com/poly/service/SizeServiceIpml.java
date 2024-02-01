package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.SizeDAO;

@Service
public class SizeServiceIpml implements SizeService{
	@Autowired
	SizeDAO sizeDAO;
}
