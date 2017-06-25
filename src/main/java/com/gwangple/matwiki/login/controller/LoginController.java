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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> login(Locale locale, @Valid LoginDto loginDto, BindingResult bindingResult) {
		
		ModelAndView mav = new ModelAndView();
		
		logger.info("파라미터 체크");
		if(bindingResult.hasErrors()){
			
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("test", loginService.getTest());
		
		logger.info("데이터확인 : [{}]", map.get("test"));
		
		mav.setViewName("/home");
		mav.addObject("parmaObject", map);
		
		return null;
	}
}
