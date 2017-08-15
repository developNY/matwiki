package com.gwangple.matwiki.login.dao;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwangple.matwiki.login.dto.LoginDto;

public class LoginDao {
	private static final Logger logger = LoggerFactory.getLogger(LoginDao.class);
	@Resource(name="sqlSession")
	private SqlSession query;
	public void setQuery(SqlSession query) {
		this.query = query;
	}
	
	public String test() throws SQLException {
		String testStr = query.selectOne("login.login");
		logger.info(testStr);
		return testStr;
    }
	
	/**
	 * 로그인 체크
	 * @return
	 * @throws SQLException
	 */
	public int loginCheck(LoginDto loginDto) throws SQLException {
		int resultCnt = query.selectOne("login.loginCheck", loginDto);
		return resultCnt;
    }
	
	//loginCheck
	
	
}
