package com.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;

}
