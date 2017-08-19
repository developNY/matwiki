package com.gwangple.matwiki.main.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwangple.matwiki.main.dto.NonUserInfoForm;
import com.gwangple.matwiki.main.dto.RsturtInfoForm;
import com.gwangple.matwiki.main.service.MainService;

@Controller
public class MainController {
	@Autowired
	private SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Resource(name = "mainService")
	private MainService mainService;

	public void setHomeService(MainService mainService) {
		this.mainService = mainService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", mainService.getList());
		
		return "main";
	} 
	
	
	@RequestMapping(value = "/createResturant", method = RequestMethod.POST)
	public String createResturant(HttpSession httpSession, Model model, 
			RsturtInfoForm rsturtInfoForm) {
		logger.debug("telNo : ",rsturtInfoForm.getTelNo());
		//비회원 입력
		mainService.insertResturant(httpSession, model, rsturtInfoForm);
		return "main";
	}   	
	
	@RequestMapping(value = "/getListRanking", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getListRanking(Locale locale ) throws Exception {
		logger.info("=====================  getListRanking ========================");
		
		logger.debug("locale{}", locale);
		
		Map<String, Object> map;
		map = mainService.getListRanking();
		return map;
	}
}
