package com.gwangple.matwiki.main.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwangple.matwiki.main.dto.NonUserInfoForm;
import com.gwangple.matwiki.main.dto.RsturtCreidMngForm;

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
	
	public void insertRsturtCreidMng(RsturtCreidMngForm rsturtCreidMngForm){
		query.insert("main.insertRsturtCreidMng", rsturtCreidMngForm);
	}
	
	public String selectRsturtMngId(){
		return query.selectOne("main.selectRsturtMngId");
	}
	
	/**
	 * 랭킹 리스트
	 * @return
	 * @throws SQLException
	 */
	 public Map<String, Object> getListRanking()throws SQLException {
		
		 List<Map<String, Object>> list = query.selectList("main.getListRanking");
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("list", list); 
		 return map;
	 }
	 
	 /**
	  * 리뷰 개수
	  * @return
	  * @throws SQLException
	  */
	  public int getListRew()throws SQLException {
			
		 List<Map<String, Object>> list = query.selectList("main.getListRew");
		 return list.size();
	  }
}
