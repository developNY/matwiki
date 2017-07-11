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
	
	/**
	 * 회원인지 비회원인지 구분하여 id반환
	 * 세션을 확인하여 회원이면 아이디반환하고
	 * ip확인하여 등록된 비회원이면 비회원아이디 반환
	 * 등록안된 비회원이면 아이디 랜덤생성후 아이디 반환
	 * @return
	 */
	public String getUserId() {
		//세션 확인
		
		//세션값 아이디 반환
		
		//세션 없으면 ip 확인후 비회원아이디 반환
		
		//비회원아이디없으면 등록후 반환
		
		return "userId";
	}
	
}
