package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.dao.UserDAO;
import com.poly.entity.User;
import com.poly.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;

	@Override
	public User save(User entity) {
		return userDAO.save(entity);
	}

	@Override
	public List<User> findAll(Sort sort) {
		return userDAO.findAll(sort);
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return userDAO.findAll(pageable);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public User findById(String id) {
		return userDAO.findById(id).get();
	}

	@Override
	public void deleteById(String id) {
		User user = findById(id);
		user.setActive(false);
		save(user);
	}

	@Override
	public void delete(User entity) {
		User user = findById(entity.getUsername());
		user.setActive(false);
		save(user);
	}

	
}