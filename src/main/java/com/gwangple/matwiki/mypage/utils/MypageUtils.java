package com.gwangple.matwiki.mypage.utils;

import javax.annotation.Resource;

import com.gwangple.matwiki.mypage.service.MypageService;

public class MypageUtils {
	
	@Resource(name="MypageService")
	static private MypageService MypageService;
	
	/**
	 *¿ÞÂÊ ÆÐµù
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

}