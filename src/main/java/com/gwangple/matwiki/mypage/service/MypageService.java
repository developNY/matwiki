package com.gwangple.matwiki.mypage.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.gwangple.matwiki.mypage.dao.MypageDao;
import com.gwangple.matwiki.mypage.utils.MypageUtils;

public class MypageService {
	
	@Resource(name="MypageDao")
	private MypageDao MypageDao;
	public void setMypageDao(MypageDao MypageDao) {
		this.MypageDao = MypageDao;
	}
	
	/**
	 * ������ ��������
	 * @param tableName
	 * @return
	 */
	@Transactional
	public String getSeqGenerator(String wsh){
		int result = 0;
		try {
			//���������� ������Ʈ
			result = MypageDao.writeWsh(wsh);
			
			//�������� ������ ���� �ͼ���
			if(1 != result){
				throw new SQLException();
			}
			
			return MypageUtils.getZeroPaddingLeft(MypageDao.getSeqGenerator(wsh), 10);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}