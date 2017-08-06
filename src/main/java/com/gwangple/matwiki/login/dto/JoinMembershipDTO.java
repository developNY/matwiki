package com.gwangple.matwiki.login.dto;

public class JoinMembershipDTO {
	private String userId;
	private String password;
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
