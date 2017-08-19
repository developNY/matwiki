package com.gwangple.matwiki.login.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gwangple.matwiki.common.service.CommService;
import com.gwangple.matwiki.common.utils.CommonUtils;
import com.gwangple.matwiki.login.dto.JoinMembershipDto;
import com.gwangple.matwiki.login.dto.LoginDto;
import com.gwangple.matwiki.login.service.LoginService;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Resource(name = "loginService")
    private LoginService loginService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @Resource(name = "commService")
    private CommService commService;

    public void setCommService(CommService commService) {
        this.commService = commService;
    }

    /**
     * 회원가입
     * @param locale
     * @param joinMembershipDTO
     * @param bindingResult
     * @param sess
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/joinMembership", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> joinMembership(Locale locale, @Valid JoinMembershipDto joinMembershipDto, BindingResult bindingResult, HttpSession sess) throws Exception {
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        //파라미터 검증
        if(bindingResult.hasErrors()) {
            CommonUtils.setErrValid(bindingResult, map);
            return map;
        }
        
        String responseCode = null;
        joinMembershipDto.setIpAddr(CommonUtils.getIpAddr());

        responseCode = loginService.getJoinValidationCheck(joinMembershipDto);
        
        if ("0000".equals(responseCode))
            responseCode = loginService.insJoinMembership(joinMembershipDto);
        
        map.put("responseCode", responseCode);
        return map;
    }

    /**
     * 로그인 실행
     * @param locale
     * @param loginDto
     * @param bindingResult
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> login(Locale locale, @Valid LoginDto loginDto, BindingResult bindingResult, HttpSession sess) throws Exception {
        
        Map<String, Object> map = null;
        String password = null;

        if(bindingResult.hasErrors()) {
            CommonUtils.setErrValid(bindingResult, map);
            return map;
        }
        
        password = CommonUtils.encryptionSHA256(loginDto.getPassword());
        loginDto.setPassword(password);
        
        map = loginService.loginCheck(loginDto);
        
        if(StringUtils.isEmpty(map) || StringUtils.isEmpty(map.get("userId"))) {
            
            map = new HashMap<String, Object>();
            map.put("responseCode", "0001");
        
        } else {
            
            loginService.setLoginInfo(sess, map);
            map.put("responseCode", "0000");
        } 

        return map;
    }
    
    /**
     * 로그아웃
     * @param locale
     * @param sess
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> logout(Locale locale, HttpSession sess) throws SQLException {
        
        Map<String, Object> map = new HashMap<String, Object>();
        loginService.logout(sess);
        map.put("responseCode", "0000");
        return map;
    }
    
    // 아이디 찾기

    // 비밀번호 찾기

}
