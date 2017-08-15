package com.gwangple.matwiki.mypage.service;

import java.sql.SQLException;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.gwangple.matwiki.mypage.dao.MypageDao;
import com.gwangple.matwiki.mypage.dto.AddWshDto;
import com.gwangple.matwiki.mypage.dto.ShowMineDto;
import com.gwangple.matwiki.mypage.dto.ShowWshDto;
import com.gwangple.matwiki.mypage.utils.MypageUtils;

public class MypageService {
	
	@Resource(name="mypageDao")
	private MypageDao mypageDao;
	public void setMypageDao(MypageDao mypageDao) {
		this.mypageDao = mypageDao;
	}
	
	/**
	 * ������ ��������
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
	
	/**
	 * ������ ��������
	 * @param tableName
	 * @return
	 */
	@Transactional
	public Map<String, Object> showWsh(ShowWshDto showWshDto){
		Map<String, Object> result;
		try {
			
			result = mypageDao.showWsh(showWshDto);
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * ������ ��������
	 * @param tableName
	 * @return
	 */
	@Transactional
	public Map<String, Object> showMine(ShowMineDto showMineDto){
		Map<String, Object> result;
		try {
			
			result = mypageDao.showMine(showMineDto);
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}