package com.gwangple.matwiki.login.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gwangple.matwiki.common.service.CommService;
import com.gwangple.matwiki.common.utils.CommonUtils;
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
	
	/**
	 * 로그인 실행
	 * @param locale
	 * @param loginDto
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> login(Locale locale, @Valid LoginDto loginDto, BindingResult bindingResult) {
		
		logger.info("파라미터 체크");
		if(bindingResult.hasErrors()){
			logger.info("필수파라미터 오류!!");
		}
		String seqTest = commService.getSeqGenerator("SEQ_TEST_TABLE");
		logger.info("시퀀스번호::[{}]",seqTest);
	
		Map<String, Object> map = new HashMap<String, Object>();
		
		//로그인 체크
		loginService.loginCheck(loginDto);
		
		return null;
	}
	
	//자동로그인 기능
	
	//페이스북 로그인
	
	//아이디 찾기
	
	//비밀번호 찾기
	
	
}
