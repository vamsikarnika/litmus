package com.fiscord.litmus.messaging.dao.api;

import com.fiscord.litmus.common.model.User;

public interface UserManagementDAO {

	
	public User addUser(User user);
	
	public User getUserByUsername(String userName);
	
	public User getUserByUserId(String userId);
	
	public String getUserPassword(String userId);
}
