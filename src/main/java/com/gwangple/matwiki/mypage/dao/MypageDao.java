package com.gwangple.matwiki.mypage.dao;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwangple.matwiki.mypage.dto.AddWshDto;

/**
 * 20`7.08.15
 * @author ¼­Çö¾Æ
 *
 */
public class MypageDao {
	private static final Logger logger = LoggerFactory.getLogger(MypageDao.class);
	@Resource(name="sqlSession")
	private SqlSession query;
	public void setQuery(SqlSession query) {
		this.query = query;
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int writeWsh(AddWshDto addWshDto) throws SQLException {
		int testStr = query.insert("mypage.addWsh");

		return testStr;
    }
}