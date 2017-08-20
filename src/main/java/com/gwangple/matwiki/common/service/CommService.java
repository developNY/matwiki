package com.gwangple.matwiki.common.service;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gwangple.matwiki.common.dao.CommDao;
import com.gwangple.matwiki.common.dto.UserInfoDto;
import com.gwangple.matwiki.common.utils.CommonUtils;
import com.gwangple.matwiki.login.service.LoginService;

public class CommService {
	
    @Resource(name="commDao")
	private CommDao commDao;
	public void setCommDao(CommDao commDao) {
		this.commDao = commDao;
	}
	
    @Resource(name = "loginService")
    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
    
	/**
	 * 시퀀스 가져오기
	 * @param tableName
	 * @return
	 */
	@Transactional
	public String getSeqGenerator(String tableName){
		int result = 0;
		try {
			//기존시퀀스 업데이트
			result = commDao.updSeqGenerator(tableName);
			
			//시퀀스가 없을때 강제 익셉션
			if(1 != result){
				throw new SQLException();
			}
			
			if( "SEQ_NON_USER_INFO".equals(tableName) ){
				return CommonUtils.getNonUserPaddingLeft( commDao.getSeqGenerator(tableName) );
			}else{
				return CommonUtils.getZeroPaddingLeft(commDao.getSeqGenerator(tableName), 10);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
    /**
     * 회원 및 비회원 정보를 불러온다.
     * @param sess
     * @return
     * @throws SQLException 
     */
    public UserInfoDto getUserInfo(HttpSession sess) throws SQLException {
        
        UserInfoDto userInfoDto = new UserInfoDto();
        
        if( StringUtils.isEmpty(sess.getAttribute("userId")) ) {
            
            userInfoDto.setUserId((String)sess.getAttribute("userId"));
            userInfoDto.setIpAddr((String)sess.getAttribute("ipAddr"));
            
        }else {
            
            userInfoDto = loginService.getNonUserInfo(CommonUtils.getIpAddr());
        }
        
        return userInfoDto;
    }
}
