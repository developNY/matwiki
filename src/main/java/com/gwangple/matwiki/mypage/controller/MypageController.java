package com.gwangple.matwiki.mypage.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwangple.matwiki.mypage.dto.AddWshDto;
import com.gwangple.matwiki.mypage.service.MypageService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MypageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	@Resource(name="mypageService")
	private MypageService mypageService;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/writeWsh", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> writeWsh(Locale locale, @Valid AddWshDto addWshDto, BindingResult bindingResult) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//파라미터 유효성 체크는 DTO 클래스에서 어노테이션 지정. HomeDto.java 참조)
		logger.info("===================writeWsh==================");
		if(bindingResult.hasErrors()){
			logger.info("잘못된 파라미터!!");
		}else{
			logger.info("파라미터 ok");
		}
		
		logger.info("값::{},{}");
		
		int reult = mypageService.writeWsh(addWshDto);
		map.put("resultValue", reult);
		return map;
	}
	

	
}