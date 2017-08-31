package com.gwangple.matwiki.main.service;

import java.net.Inet4Address;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.gwangple.matwiki.common.dto.UserInfoDto;
import com.gwangple.matwiki.common.service.CommService;
import com.gwangple.matwiki.login.service.LoginService;
import com.gwangple.matwiki.main.dao.MainDao;
import com.gwangple.matwiki.main.dto.NonUserInfoForm;
import com.gwangple.matwiki.main.dto.RsturtCreidMngForm;
import com.gwangple.matwiki.main.dto.RsturtInfoForm;

public class MainService {
	private static final Logger logger = LoggerFactory.getLogger(MainService.class);
	@Resource(name = "mainDao")
	private MainDao mainDao;

	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}

	@Resource(name = "commService")
	private CommService commService;

	public void setCommService(CommService commService) {
		this.commService = commService;
	}

	@Resource(name = "loginService")
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getList() {
		try {
			return mainDao.test();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public void insertMain(HttpSession httpSession, Model model, final RsturtInfoForm rsturtInfoForm) {
		try {
			String rsturtMngId = getRsturtMngId(rsturtInfoForm);
			logger.info("rsturtMngId : {} " + rsturtMngId);
			if (isRsturtMngId(rsturtInfoForm)) insertRsturtCreidMng(httpSession, rsturtMngId, rsturtInfoForm);
			insertResturant(httpSession, model,rsturtMngId, rsturtInfoForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	public void insertResturant(HttpSession httpSession, Model model,final String rsturtMngId, final RsturtInfoForm rsturtInfoForm) {
		NonUserInfoForm nonUserInfoForm = new NonUserInfoForm();
		try {
			nonUserInfoForm = setNonUserInfoForm(httpSession, rsturtInfoForm);
			RsturtInfoForm rsturtInfoFormResult = new RsturtInfoForm();
			rsturtInfoFormResult = setRsturtInfoForm(httpSession, rsturtMngId, rsturtInfoForm, nonUserInfoForm);
			//맛집메인테이블입력
			if (isRsturtInfo(rsturtInfoFormResult)) {
				mainDao.updateRsturtInfo(rsturtInfoFormResult);
			} else {
				mainDao.insertRsturtInfo(rsturtInfoFormResult);
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
		}
	}
	
	//맛집메인등록테이블 입력값 세팅
	public RsturtInfoForm setRsturtInfoForm(final HttpSession httpSession, final String rsturtMngId,
			final RsturtInfoForm rsturtInfoForm, final NonUserInfoForm nonUserInfoForm){
		RsturtInfoForm RsturtInfoFormParam = rsturtInfoForm;
		try {
			RsturtInfoFormParam.setRsturtMngId(rsturtMngId);
			String ipAddr = Inet4Address.getLocalHost().getHostAddress();
			UserInfoDto userInfoDto = loginService.getNonUserInfo(ipAddr);
			RsturtInfoFormParam.setCreateId(userInfoDto.getUserId());
			RsturtInfoFormParam.setUptId(userInfoDto.getUserId());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return RsturtInfoFormParam;
	}
	
	public void insertRsturtCreidMng(HttpSession httpSession, final String rsturtMngId,final RsturtInfoForm rsturtInfoForm) {
		// 키생성 테이블
		try {
			RsturtCreidMngForm rsturtCreidMngForm = setRsturtCreidMngForm(httpSession, rsturtMngId, rsturtInfoForm);
			//맛집채번테이블 입력
			mainDao.insertRsturtCreidMng(rsturtCreidMngForm);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//맛집채번값 얻기 
	public String getRsturtMngId(RsturtInfoForm rsturtInfoForm){
		String rsturtMngId = "";
		HashMap<String, Object> resultMap = mainDao.selectRsturtMngId(rsturtInfoForm.getRsturtNm(), rsturtInfoForm.getAddr());
		if (resultMap != null && resultMap.get(null) != null) {
			HashMap<String,Object> subResultMap = (HashMap<String, Object>) resultMap.get(null);
			rsturtMngId = subResultMap.get("RSTURT_MNG_ID").toString();
		} else {
			rsturtMngId = mainDao.selectKeyRsturtMngId();
		}
		logger.info("rsturtMngId : "+rsturtMngId);
		return rsturtMngId;
	}
	
	public boolean isRsturtMngId(RsturtInfoForm rsturtInfoForm){
		String rsturtMngId = "";
		HashMap<String, Object> resultMap = mainDao.selectRsturtMngId(rsturtInfoForm.getRsturtNm(), rsturtInfoForm.getAddr());
		if (resultMap != null && resultMap.get(null) != null) {
			HashMap<String,Object> subResultMap = (HashMap<String, Object>) resultMap.get(null);
			rsturtMngId = subResultMap.get("RSTURT_MNG_ID").toString();
		}
		if (!"".equals(rsturtMngId)) return false;
		return true;
	}
	
	//맛집채번테이블 입력값 세팅
	public RsturtCreidMngForm setRsturtCreidMngForm(final HttpSession httpSession, final String rsturtMngId, final RsturtInfoForm rsturtInfoForm) {
		RsturtCreidMngForm rsturtCreidMngForm = new RsturtCreidMngForm();
		try {
			rsturtCreidMngForm.setRsturtMngId(rsturtMngId);
			rsturtCreidMngForm.setRsturtNm(rsturtInfoForm.getRsturtNm());
			rsturtCreidMngForm.setAddr(rsturtInfoForm.getAddr());
			rsturtCreidMngForm.setTel(rsturtInfoForm.getTelNo());
			String ipAddr = Inet4Address.getLocalHost().getHostAddress();
			UserInfoDto userInfoDto = loginService.getNonUserInfo(ipAddr);
			rsturtCreidMngForm.setCreateId(userInfoDto.getUserId());
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug(e.getMessage());
		}
		return rsturtCreidMngForm;
	}
	
	//비회원 입력값 세팅
	public NonUserInfoForm setNonUserInfoForm(final HttpSession httpSession, final RsturtInfoForm rsturtInfoForm) {
		NonUserInfoForm nonUserInfoForm = new NonUserInfoForm();
		try {
			String ipAddr = Inet4Address.getLocalHost().getHostAddress();
			logger.info("ipAddress : {} " + ipAddr);
			nonUserInfoForm.setIp(ipAddr);
			UserInfoDto userInfoDto = loginService.getNonUserInfo(ipAddr);
			logger.info("selectGetNonUserId {} " + userInfoDto.getUserId());
			nonUserInfoForm.setNonUserId(userInfoDto.getUserId());
			nonUserInfoForm.setCreateId(userInfoDto.getUserId());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return nonUserInfoForm;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isRsturtInfo(RsturtInfoForm rsturtInfoForm){
		HashMap<String, Object> resultMap = (HashMap<String, Object>) mainDao.selectRsturtInfo(rsturtInfoForm.getRsturtMngId());
		HashMap<String, Object> subResultMap = null;
		if (resultMap != null && resultMap.get(null) != null) {
			subResultMap = (HashMap<String, Object>) resultMap.get(null);
		}
		if (subResultMap == null || "".equals(subResultMap.get("RSTURT_MSG_ID"))) return false;
		return true;
	}
	
	/**
	 * 랭킹 불러오기
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getListRanking() throws SQLException {
		return mainDao.getListRanking();
	}

	/**
	 * 리뷰 개수
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getListRew() throws SQLException {
		return mainDao.getListRew();
	}
}
