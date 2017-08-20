package com.gwangple.matwiki.common.utils;

import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gwangple.matwiki.login.controller.LoginController;

public class CommonUtils {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 *왼쪽 패딩
	 * @param args
	 */
	public static String getZeroPaddingLeft(String str, int len) {
		String result = "";
		
		int strLen = str.length();
		
		if(strLen >= len){
			return str;
		}
		
		int paddingCnt = len - strLen;
		
		for(int i = 0; i < paddingCnt; i++){
			result += "0";
		}
		
		result = result + str; 
		
		return result;
	}
	
	/**
	 *왼쪽 패딩
	 * @param args
	 */
	public static String getNonUserPaddingLeft(String str) {
		String result = "";
		String nonUser = "user";
		int len = 6;
		
		int strLen = str.length();
		
		if(strLen >= len){
			return nonUser + str;
		}
		
		int paddingCnt = len - strLen;
		
		for(int i = 0; i < paddingCnt; i++){
			result += "0";
		}
		
		result = nonUser + result + str; 
		
		return result;
	}
	
	/**
	 * password를 SHA-256 으로
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String encryptionSHA256(String password) throws Exception {
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(password.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();
		
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        
		return hexString.toString();
	}
	
	/**
	 * 클라이언트 ip주소를 호출합니다.
	 * @return String
	 */
	public static String getIpAddr() {
        
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest(); 
        String ip = null;
        
        //웹서버 통해 들어올 경우
        ip = req.getHeader("X-FORWARDED-FOR");
        
        if (ip == null)
            ip = req.getRemoteAddr();
	    
	    return ip;
    }
	
	/**
	 * 파리미터 검증 오류시 오류코드 set
	 * @param bindingResult
	 * @param map
	 */
	public static void setErrValid(BindingResult bindingResult, Map<String, Object> map) {
        
	    List<ObjectError> errors = bindingResult.getAllErrors();
        for(ObjectError error : errors) {
            logger.info("error:[{}]", error.getDefaultMessage());
        }
        
        map.put("responseCode", "9999");
    }
}
