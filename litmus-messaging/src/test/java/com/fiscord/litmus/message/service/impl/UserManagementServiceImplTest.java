package com.fiscord.litmus.message.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fiscord.litmus.common.model.User;
import com.fiscord.litmus.messaging.service.api.UserManagementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:litmus/spring/spring-web-config-test.xml")
public class UserManagementServiceImplTest {

	@Autowired
	private UserManagementService userManagement;
	
	@Test
	public void testNotNull() {
		userManagement.addUser(getUser());
		Assert.assertNotNull(userManagement);
	}
	
	private User getUser() {
		User vamsi = new User( "123", "Vegeta", 23, "vamsikarnika@gmail.com");
		return vamsi;
	}

}
