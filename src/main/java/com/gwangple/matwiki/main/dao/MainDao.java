package com.gwangple.matwiki.main.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * 랭킹 불러오기
	 * @return
	 * @throws SQLException
	 */
	 public Map<String, Object> getListRanking()throws SQLException {
		
		 List<Map<String, Object>> list = query.selectList("main.getListRanking");
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("list", list); 
		 return map;
	 }
}
