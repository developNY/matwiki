package com.gwangple.matwiki.login.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwangple.matwiki.common.service.CommService;
import com.gwangple.matwiki.login.dto.LoginDto;
import com.gwangple.matwiki.login.service.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Resource(name="loginService")
	private LoginService loginService;
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Resource(name="commService")
	private CommService commService;
	public void setCommService(CommService commService) {
		this.commService = commService;
	}
	
	//회원가입
	
	/**
	 * 로그인 실행
	 * @param locale
	 * @param loginDto
	 * @param bindingResult
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> login(Locale locale, @Valid LoginDto loginDto, BindingResult bindingResult, HttpSession sess) throws SQLException {
		String sessStr = (String)sess.getAttribute("ss");
		
		/*
		 * 테스트 코드  start ========================================================================
		 */
		logger.info("세션값1::[{}]"+sessStr);
		
		if(sessStr == null){
			sess.setAttribute("ss", "sessSuccess!!");
			sessStr = (String)sess.getAttribute("ss");
		}
		
		logger.info("세션값2::[{}]"+sessStr);
		
		String seqTest = commService.getSeqGenerator("SEQ_NON_USER_INFO");
		logger.info("시퀀스번호::[{}]",seqTest);
	
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("seq", seqTest);
		
		/*
		 * 테스트 코드 end ========================================================================
		 */
		
		//파라미터 validation check
		if(bindingResult.hasErrors()){
			logger.info("필수파라미터 오류!!");
			return null;
		}
		
		//아이디 패스워드 확인
		int loginResult = loginService.loginCheck(loginDto);
		
		if( loginResult == 0 ){
			//아이디가 없거나 패스워드가 틀립니다 
			return null;
		}else if( loginResult == 1 ){
			//로그인 성공
			//세션 설정
			//userDto로 만들어서 관리
			return null;
		}else if( loginResult <= -1 ){
			//오류 
			return null;
		}
		
		return map;
	}
	
	//로그인 확인
	
	//자동로그인 기능
	
	//페이스북 로그인
	
	//아이디 찾기
	
	//비밀번호 찾기
	
}
