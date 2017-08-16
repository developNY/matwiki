package com.gwangple.matwiki.main.dao;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwangple.matwiki.dao.HomeDao;
import com.gwangple.matwiki.main.dto.NonUserInfoForm;

public class MainDao {
	private static final Logger logger = LoggerFactory.getLogger(MainDao.class);
	@Resource(name="sqlSession")
	private SqlSession query;
	public void setQuery(SqlSession query) {
		this.query = query;
	}
	
	public String test() throws SQLException {
		String list = query.selectOne("main.list");
		logger.info(list);
		return list;
    }
	
	public void insertNonUserInfo(NonUserInfoForm nonUserInfoForm){
		query.insert("main.insertNonUserInfoForm", nonUserInfoForm);
	}
}
