package com.gwangple.matwiki.login.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import com.gwangple.matwiki.login.dao.LoginDao;
import com.gwangple.matwiki.login.dto.LoginDto;

public class LoginService {

	@Resource(name="loginDao")
	private LoginDao loginDao;
	public void setHomeDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	/**
	 * 테스트
	 * @return
	 */
	public String getTest(){
		try {
			return loginDao.test();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	/**
	 * 로그인 체크
	 * @return
	 */
	public String loginCheck(LoginDto loginDto) {
		
		return "";
	}
	
}
