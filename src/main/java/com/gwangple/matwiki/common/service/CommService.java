package com.gwangple.matwiki.common.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.gwangple.matwiki.common.dao.CommDao;
import com.gwangple.matwiki.common.utils.CommonUtils;

public class CommService {
	@Resource(name="commDao")
	private CommDao commDao;
	public void setCommDao(CommDao commDao) {
		this.commDao = commDao;
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
}
