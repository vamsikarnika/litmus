package com.fiscord.litmus.messaging.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscord.litmus.common.model.User;
import com.fiscord.litmus.messaging.dao.api.UserManagementDAO;
import com.fiscord.litmus.messaging.service.api.UserManagementService;

@Service
public class UserManagemetServiceImpl implements UserManagementService{

	@Autowired
	private UserManagementDAO userManagementDAO;
	
	@Override
	public User addUser(User user) {
		System.out.println("Processing User");
		userManagementDAO.addUser(user);
		return user;
	}

}
