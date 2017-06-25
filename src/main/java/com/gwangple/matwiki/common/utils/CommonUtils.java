package com.gwangple.matwiki.common.utils;

public class CommonUtils {

	/**
	 *왼쪽 패딩
	 * @param args
	 */
	public static String getPaddingLeft(String str, int len) {
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
