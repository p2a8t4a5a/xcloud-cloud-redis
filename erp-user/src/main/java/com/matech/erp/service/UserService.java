package com.matech.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matech.erp.mapper.UserMapper;
import com.matech.erp.model.User;

@Service
public class UserService {

	@Autowired
	UserMapper userDao;
	
	public User findByUsername(String username) {
		User user = userDao.getUserByName(username);
		return user;
	}
	
	
}
