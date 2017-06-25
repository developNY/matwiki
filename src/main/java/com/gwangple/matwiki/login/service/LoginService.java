package com.gwangple.matwiki.login.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import com.gwangple.matwiki.login.dao.LoginDao;

public class LoginService {

	@Resource(name="loginDao")
	private LoginDao loginDao;
	public void setHomeDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public String getTest(){
		try {
			return loginDao.test();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
