package com.gwangple.matwiki.login.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import com.gwangple.matwiki.common.utils.CommonUtils;
import com.gwangple.matwiki.login.dao.LoginDao;
import com.gwangple.matwiki.login.dto.JoinMembershipDTO;
import com.gwangple.matwiki.login.dto.LoginDto;

public class LoginService {

	@Resource(name="loginDao")
	private LoginDao loginDao;
	public void setHomeDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	/**
	 * 로그인 체크
	 * @return
	 * @throws SQLException 
	 */
	public int loginCheck(LoginDto loginDto) throws SQLException {
		return loginDao.loginCheck(loginDto);
	}
	
	public String getJoinValidationCheck(JoinMembershipDTO joinMembershipDTO) throws Exception {
		
		String result = "";
		String userId = joinMembershipDTO.getUserId();
		String encryptPW = CommonUtils.encryptionSHA256(joinMembershipDTO.getPassword());
		String encryptPWConfirm = CommonUtils.encryptionSHA256(joinMembershipDTO.getPasswordConfirm());
		
		if(getUserId(userId) != 0){
			result = "0001";
			return result;
		}else if(getPasswordCompare(encryptPW, encryptPWConfirm)){
			result = "0002";
			return result;
		}else{
			result = "0000";
		}
		
		return result;
	}
	
	public int getUserId(String userId) throws SQLException {
		int result = -1;
		/*result = loginDao.getUserId(userId);*/
		return result; 
	}
	
	public boolean getPasswordCompare(String password, String passwordConfirm) {
		
		boolean result = password.equals(passwordConfirm);
		
		return result;
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
