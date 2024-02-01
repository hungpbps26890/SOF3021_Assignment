package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AddressDAO;

@Service
public class AddressServiceIpml implements AddressService {
	@Autowired
	AddressDAO addressDAO;

}
