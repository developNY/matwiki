package com.gwangple.matwiki.common.utils;

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
	 * 시쿼스 생성
	 * @param tableName(생성할 시퀀스 테이블명)
	 * @return
	 */
	public static String getSeqGenerator(String tableName) {
		return getZeroPaddingLeft(commService.getSeqGenerator(tableName), 10);
	}

}
