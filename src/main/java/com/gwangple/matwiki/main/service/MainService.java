package com.gwangple.matwiki.main.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.gwangple.matwiki.common.service.CommService;
import com.gwangple.matwiki.main.dao.MainDao;
import com.gwangple.matwiki.main.dto.NonUserInfoForm;
import com.gwangple.matwiki.main.dto.RsturtInfoForm;

public class MainService {
	private static final Logger logger = LoggerFactory.getLogger(MainService.class);
	@Resource(name="mainDao")
	private MainDao mainDao;
	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}
	
	@Resource(name="commService")
	private CommService commService;
	public void setCommService(CommService commService) {
		this.commService = commService;
	}

	public String getList(){
		try {
			return mainDao.test();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public void insertResturant(HttpSession httpSession, Model model, RsturtInfoForm rsturtInfoForm){
		NonUserInfoForm nonUserInfoForm = new NonUserInfoForm();
		nonUserInfoForm.setIp("");
		//비회원 입력
		mainDao.insertNonUserInfo(nonUserInfoForm);
		//채번 
		String seqNo = commService.getSeqGenerator("RSTURT_CREID_MNG");
		
	}
}
