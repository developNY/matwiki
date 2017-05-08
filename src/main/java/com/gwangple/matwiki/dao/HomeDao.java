package com.gwangple.matwiki.dao;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeDao {
	private static final Logger logger = LoggerFactory.getLogger(HomeDao.class);
	@Resource(name="sqlSession")
	private SqlSession query;
	public void setQuery(SqlSession query) {
		this.query = query;
	}
	
	public String test() throws SQLException {
		String testStr = query.selectOne("query.test");
		logger.info(testStr);
		return testStr;
    }
}
