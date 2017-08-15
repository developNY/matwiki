package com.gwangple.matwiki.mypage.service;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.gwangple.matwiki.mypage.dao.MypageDao;
import com.gwangple.matwiki.mypage.dto.AddWshDto;
import com.gwangple.matwiki.mypage.utils.MypageUtils;

public class MypageService {
	
	@Resource(name="mypageDao")
	private MypageDao mypageDao;
	public void setMypageDao(MypageDao mypageDao) {
		this.mypageDao = mypageDao;
	}
	
	/**
	 * 시퀀스 가져오기
	 * @param tableName
	 * @return
	 */
	@Transactional
	public int writeWsh(AddWshDto addWshDto){
		int result = 0;
		try {
			
			result = mypageDao.writeWsh(addWshDto);
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
}