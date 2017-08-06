package com.gwangple.matwiki.common.utils;

import java.security.MessageDigest;

import javax.annotation.Resource;

import com.gwangple.matwiki.common.service.CommService;

public class CommonUtils {
	
	@Resource(name="commService")
	static private CommService commService;
	
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
        
        //출력
        System.out.println(hexString.toString());
		return hexString.toString();
	}

}
