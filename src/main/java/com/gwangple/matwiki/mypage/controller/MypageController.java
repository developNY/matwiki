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
import com.gwangple.matwiki.mypage.dto.ShowMineDto;
import com.gwangple.matwiki.mypage.dto.ShowWshDto;
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
		
		//�Ķ���� ��ȿ�� üũ�� DTO Ŭ�������� ������̼� ����. HomeDto.java ����)
		logger.info("===================writeWsh==================");
		if(bindingResult.hasErrors()){
			logger.info("�߸��� �Ķ����!!");
		}else{
			logger.info("�Ķ���� ok");
		}
		
		logger.info("��::{},{}");
		
		int reult = mypageService.writeWsh(addWshDto);
		map.put("resultValue", reult);
		return map;
	}
	
	@RequestMapping(value = "/showWsh", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> showWsh(Locale locale, @Valid ShowWshDto showWshDto, BindingResult bindingResult) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//�Ķ���� ��ȿ�� üũ�� DTO Ŭ�������� ������̼� ����. HomeDto.java ����)
		logger.info("===================showWsh==================");
		if(bindingResult.hasErrors()){
			logger.info("�߸��� �Ķ����!!");
		}else{
			logger.info("�Ķ���� ok");
		}
		
		logger.info("��::{},{}");
		
		Map<String, Object> reult = mypageService.showWsh(showWshDto);
		map.put("resultValue", reult);
		return map;
	}
	
	@RequestMapping(value = "/showMine", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> showMine(Locale locale, @Valid ShowMineDto showMineDto, BindingResult bindingResult) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//�Ķ���� ��ȿ�� üũ�� DTO Ŭ�������� ������̼� ����. HomeDto.java ����)
		logger.info("===================showMine==================");
		if(bindingResult.hasErrors()){
			logger.info("�߸��� �Ķ����!!");
		}else{
			logger.info("�Ķ���� ok");
		}
		
		logger.info("��::{},{}");
		
		Map<String, Object> reult = mypageService.showMine(showMineDto);
		map.put("resultValue", reult);
		return map;
	}
	
}