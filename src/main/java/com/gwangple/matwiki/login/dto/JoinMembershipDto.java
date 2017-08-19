package com.gwangple.matwiki.login.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class JoinMembershipDto {
    
    @NotEmpty
	private String userId;
    @NotEmpty
	private String password;
    @NotEmpty
	private String passwordConfirm;
	private String ipAddr;
	
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	@Override
	public String toString() {
		return "JoinMembership [userId=" + userId + ", password=" + password + ", passwordConfirm=" + passwordConfirm
				+ ", ipAddr=" + ipAddr + "]";
	}
}
