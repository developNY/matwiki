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
	
	//맛집등록 메인
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
	
	//맛집등록
	public void insertResturant(HttpSession httpSession, Model model,final String rsturtMngId, final RsturtInfoForm rsturtInfoForm) {
		NonUserInfoForm nonUserInfoForm = new NonUserInfoForm();
		try {
			nonUserInfoForm = setNonUserInfoForm(httpSession, rsturtInfoForm);
			RsturtInfoForm rsturtInfoFormResult = new RsturtInfoForm();
			rsturtInfoFormResult = setRsturtInfoForm(httpSession, rsturtMngId, rsturtInfoForm, nonUserInfoForm);
			//맛집메인테이블입력. 데이터있으면 업데이트, 없으면 입력
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
	
	//맛집채번테이블 입력
	public void insertRsturtCreidMng(HttpSession httpSession, final String rsturtMngId,final RsturtInfoForm rsturtInfoForm) {
		// 키생성 테이블
		try {
			RsturtCreidMngForm rsturtCreidMngForm = setRsturtCreidMngForm(httpSession, rsturtMngId, rsturtInfoForm);
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
	
	//맛집관리테이블 등록유무
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
	
	//맛집들록유무
	@SuppressWarnings("unchecked")
	public boolean isRsturtInfo(RsturtInfoForm rsturtInfoForm){
		try {
			String ipAddr = Inet4Address.getLocalHost().getHostAddress();
			UserInfoDto userInfoDto = loginService.getNonUserInfo(ipAddr);
			HashMap<String, Object> resultMap = (HashMap<String, Object>) mainDao.selectRsturtInfo(rsturtInfoForm.getRsturtMngId(),userInfoDto.getUserId());
			HashMap<String, Object> subResultMap = null;
			if (resultMap != null && resultMap.get(null) != null) {
				subResultMap = (HashMap<String, Object>) resultMap.get(null);
			}
			if (subResultMap == null || "".equals(subResultMap.get("RSTURT_MSG_ID"))) return false;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			return false;
		}
		return true;
	}
	
	public void updateMain(HttpSession httpSession, Model model, RsturtInfoForm rsturtInfoForm){
		mainDao.updateRsturtInfo(rsturtInfoForm);
	}
	
	public Map<String, Object> getRsturtInfo(HttpSession httpSession, final Model model, final RsturtInfoForm rsturtInfoForm){
		Map<String, Object> rsturtInfoFormResult = new HashMap<String, Object>();
		try {
			String ipAddr = Inet4Address.getLocalHost().getHostAddress();
			UserInfoDto userInfoDto = loginService.getNonUserInfo(ipAddr);
			rsturtInfoFormResult = mainDao.selectRsturtInfo(rsturtInfoForm.getRsturtMngId(), userInfoDto.getUserId());
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
		}
		return rsturtInfoFormResult;
	}
	
	/**
	 * 랭킹 불러오기
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getListRanking(int absPage, int pageCount) throws SQLException {
		return mainDao.getListRanking(absPage, pageCount);
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
