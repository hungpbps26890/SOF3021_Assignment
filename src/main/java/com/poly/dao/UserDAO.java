package com.poly.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.User;

public interface UserDAO extends JpaRepository<User, String> {
	Page<User> findByUsernameContainingOrFirstNameContainingOrLastNameContaining(String username, String firstName, String lastName, Pageable pageable);
	Page<User> findByPhoneNumberContaining(String phoneNumber, Pageable pageable);
	Page<User> findByEmailContaining(String email, Pageable pageable);
}
