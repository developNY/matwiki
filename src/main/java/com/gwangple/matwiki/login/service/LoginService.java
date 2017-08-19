package com.gwangple.matwiki.login.service;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.gwangple.matwiki.common.dto.UserInfoDto;
import com.gwangple.matwiki.common.service.CommService;
import com.gwangple.matwiki.common.utils.CommonUtils;
import com.gwangple.matwiki.login.dao.LoginDao;
import com.gwangple.matwiki.login.dto.JoinMembershipDto;
import com.gwangple.matwiki.login.dto.LoginDto;

public class LoginService {

    @Resource(name = "loginDao")
    private LoginDao loginDao;

    public void setHomeDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    
    @Resource(name = "commService")
    private CommService commService;

    public void setCommService(CommService commService) {
        this.commService = commService;
    }

    /**
     * 로그인
     * @return
     * @throws SQLException
     */
    public Map<String, Object> loginCheck(LoginDto loginDto) throws SQLException {
        return loginDao.loginCheck(loginDto);
    }

    /**
     * 회원가입 파라미터 검증
     * 
     * @param joinMembershipDTO
     * @return 검증확인 : "0000", 기존 가입된ID 존재 : "0001", 패스워드 오입력 : "0002"
     * @throws Exception
     */
    public String getJoinValidationCheck(JoinMembershipDto joinMembershipDto) throws Exception {

        String result = "";
        String userId = joinMembershipDto.getUserId();
        String encryptPW = joinMembershipDto.getPassword();
        String encryptPWConfirm = joinMembershipDto.getPasswordConfirm();

        if ("Y".equals(getUserIdYn(userId))) {
            result = "0001";
        } else if (!getPasswordCompare(encryptPW, encryptPWConfirm)) {
            result = "0002";
        } else {
            result = "0000";
            // 검증 완료시 비민번호 암호화
            joinMembershipDto.setPassword(CommonUtils.encryptionSHA256(encryptPW));
            joinMembershipDto.setPasswordConfirm(null);
        }

        return result;
    }

    /**
     * 등록된 ID 확인
     * 
     * @param userId
     * @return "Y" or "N"
     * @throws SQLException
     */
    public String getUserIdYn(String userId) throws SQLException {

        String stringValue = null;
        stringValue = loginDao.getUserIdYn(userId);

        return "Y".equals(stringValue) ? stringValue : "N";
    }

    /**
     * 회원가입시 패스워드와 패스워드확인번호 검증
     * 
     * @param password
     * @param passwordConfirm
     * @return
     */
    public boolean getPasswordCompare(String password, String passwordConfirm) {

        boolean result = false;

        if (password != null) 
            result = password.equals(passwordConfirm);

        return result;
    }

    /**
     * 회원가입
     * 
     * @param joinMembershipDTO
     * @return
     * @throws SQLException
     */
    public String insJoinMembership(JoinMembershipDto joinMembershipDto) throws SQLException {

        String responseCode = null;
        int resultCnt = 0;

        resultCnt = loginDao.insJoinMembership(joinMembershipDto);

        if (resultCnt == 1)  responseCode = "0000";
        else                 responseCode = "0003";

        return responseCode;
    }
    
    /**
     * 사용자정보 set
     * @param sess
     * @param map
     */
    public void setLoginInfo(HttpSession sess, Map<String, Object> map) {
        sess.setAttribute("userId", (String) map.get("userId"));
        sess.setAttribute("ipAddr", (String) map.get("ipAddr"));
    }
    
    /**
     * 비회원 정보를 가져온다
     * @param ipAddr
     * @return
     * @throws SQLException
     */
    public UserInfoDto getNonUserInfo(String ipAddr) throws SQLException {
        
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto = loginDao.getNonUserInfo(ipAddr);
        
        if(userInfoDto == null || userInfoDto.getUserId() == null) {
            
            setNonUserInfo(ipAddr);
            userInfoDto = loginDao.getNonUserInfo(ipAddr);
        }
        
        return userInfoDto;
    }
    
    /**
     * 비회원정보를 저장한다
     * @param ipAddr
     * @throws SQLException
     */
    public void setNonUserInfo(String ipAddr) throws SQLException {
        
        UserInfoDto userInfoDto = new UserInfoDto();
        String nonUserId = commService.getSeqGenerator("SEQ_NON_USER_INFO");
        
        userInfoDto.setUserId(nonUserId);
        userInfoDto.setIpAddr(ipAddr);
        
        loginDao.setNonUserInfo(userInfoDto);
    }
    
    /**
     * 로그아웃
     * @param sess
     */
    public void logout(HttpSession sess) {
        sess.invalidate();
    }
    
    /**
     * 삭제할것
     * 
     * @return
     */
    public String getUserId() {
        // 세션 확인

        // 세션값 아이디 반환

        // 세션 없으면 ip 확인후 비회원아이디 반환

        // 비회원아이디없으면 등록후 반환

        return "userId";
    }

}
