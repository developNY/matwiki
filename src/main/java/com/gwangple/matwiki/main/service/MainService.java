package com.gwangple.matwiki.main.service;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.gwangple.matwiki.common.service.CommService;
import com.gwangple.matwiki.main.dao.MainDao;
import com.gwangple.matwiki.main.dto.NonUserInfoForm;
import com.gwangple.matwiki.main.dto.RsturtCreidMngForm;
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
		//비회원 등록
		mainDao.insertNonUserInfo(nonUserInfoForm);
		//키생성 테이블
		String rsturtMngId = mainDao.selectRsturtMngId();
		logger.info("rsturtMngId : {} " + rsturtMngId);
		setRsturtCreidMngForm(httpSession, rsturtMngId, rsturtInfoForm);
		
	}
	
	public RsturtCreidMngForm setRsturtCreidMngForm(final HttpSession httpSession, final String rsturtMngId, final RsturtInfoForm rsturtInfoForm){
		RsturtCreidMngForm rsturtCreidMngForm = new RsturtCreidMngForm();	
		try {
			rsturtCreidMngForm.setRsturtMngId(rsturtMngId);
			rsturtCreidMngForm.setRsturtNm(rsturtInfoForm.getRsturtId());
			rsturtCreidMngForm.setAddr(rsturtInfoForm.getAddr());
			rsturtCreidMngForm.setTel(rsturtInfoForm.getTelNo());
			rsturtCreidMngForm.setCreateId(commService.getUserInfo(httpSession).getUserId());
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug(e.getMessage());
		}
		return rsturtCreidMngForm;
	}
	
	
	/**
	 * 랭킹 불러오기
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getListRanking() throws SQLException{
		return mainDao.getListRanking();		
	}
	
	/**
	 * 리뷰 개수
	 * @return
	 * @throws SQLException
	 */
	public int getListRew() throws SQLException{
		return mainDao.getListRew();		
	}
}
