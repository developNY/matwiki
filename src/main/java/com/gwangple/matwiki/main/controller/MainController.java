/**
 * MainController  맛집등록,조회,상세보기  MainController 클래스 입니다.
 * @author 김나연, 최대호 
 * @since 2017.08.09
 * @version 1.0
 * <pre>
 * 2017.08.09 : 최초 작성
 * </pre>
 */
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
@RequestMapping(value = "/main")
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
		logger.info("telNo {}: ",rsturtInfoForm.getTelNo());
		//맛집등록
		mainService.insertMain(httpSession, model, rsturtInfoForm);
		return "main";
	}
	
	@RequestMapping(value = "/updateResturant", method = RequestMethod.POST)
	public String updateResturant(HttpSession httpSession, Model model, 
			RsturtInfoForm rsturtInfoForm) {
		logger.info("telNo {}: ",rsturtInfoForm.getTelNo());
		//맛집등록
		mainService.updateMain(httpSession, model, rsturtInfoForm);
		return "main";
	}
	
	@RequestMapping(value = "/detailResturant", method = RequestMethod.POST)
	public String detailResturant(HttpSession httpSession, Model model, 
			RsturtInfoForm rsturtInfoForm) {
		logger.info("telNo {}: ",rsturtInfoForm.getTelNo());
		//맛집등록
		Map<String, Object> resultMap = mainService.getRsturtInfo(httpSession, model, rsturtInfoForm);
		logger.info("resultMap : "+resultMap.toString());
		return "main";
	}
	
	//랭킹보기
	@RequestMapping(value = "/getListRanking", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getListRanking(Locale locale, int absPage, int pageCount) throws Exception {
		logger.info("=====================  getListRanking ========================");
		
		logger.info("locale{}", locale);
		
		Map<String, Object> map;
		map = mainService.getListRanking(absPage, pageCount);
		return map;
	}
}
