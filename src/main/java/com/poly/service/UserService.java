package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.poly.entity.User;

public interface UserService {

	void delete(User entity);

	void deleteById(String id);

	User findById(String id);

	List<User> findAll();
	
	Page<User> findAll(Pageable pageable);

	List<User> findAll(Sort sort);

	User save(User entity);
	
	//List<User> findByUsernameContainingOrFirstNameContainingOrLastNameContaining(String username, String firstName, String lastName);
	Page<User> findByUsernameContainingOrFirstNameContainingOrLastNameContaining(String username, String firstName, String lastName, Pageable pageable);
	
	Page<User> findByPhoneNumberContaining(String phonenumber, Pageable pageable);
	
	Page<User> findByEmailContaining(String email, Pageable pageable);
	
	
}
