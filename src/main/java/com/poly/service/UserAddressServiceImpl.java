package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.UserAddressDAO;

@Service
public class UserAddressServiceImpl implements UserAddressService {
	@Autowired
	UserAddressDAO userAddressDAO;

}
