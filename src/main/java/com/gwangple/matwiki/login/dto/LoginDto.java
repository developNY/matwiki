package com.gwangple.matwiki.login.dto;

import org.hibernate.validator.constraints.NotEmpty;


public class LoginDto {
	
	@NotEmpty
	private String userId;
	@NotEmpty
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [userId=" + userId + ", password=" + password + "]";
	}
	
}
