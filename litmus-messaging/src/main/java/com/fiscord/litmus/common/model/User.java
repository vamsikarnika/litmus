package com.fiscord.litmus.common.model;

public class User {
	
	private String userId;
	private String userName;
	private Integer age;
	private String emailId;
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		
	}
	
	public User(String userId) {
		this.userId=userId;
	}
	
	public User(String userId, String userName, Integer age, String emailId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
		this.emailId = emailId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
}
