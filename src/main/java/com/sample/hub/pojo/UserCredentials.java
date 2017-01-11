package com.sample.hub.pojo;

import com.sample.hub.util.HashingUtil;

public class UserCredentials {

	private String userId;
	private transient String password;
	private String passwordHash;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPassword(String password) {
		this.password = password;
		this.passwordHash = HashingUtil.getPasswordHash(password);
	}
	
}
