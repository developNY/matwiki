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
import com.gwangple.matwiki.main.dto.RsturtInfoForm;

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
	
	//맛집채번테이블 입력
	public void insertRsturtCreidMng(RsturtCreidMngForm rsturtCreidMngForm){
		query.insert("main.insertRsturtCreidMng", rsturtCreidMngForm);
	}
	//맛집등록
	public void insertRsturtInfo(RsturtInfoForm rsturtInfoForm){
		query.insert("main.insertRsturtInfo", rsturtInfoForm);
	}
	//키값 조회
	public String selectKeyRsturtMngId(){
		return query.selectOne("main.selectKeyRsturtMngId");
	}
	
	public Map<String, Object> selectRsturtInfo(String rsturtMngId, String userId){
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rsturtMngId", rsturtMngId);
		paramMap.put("userId", userId);
		return query.selectMap("selectRsturtInfo", paramMap, "main");
	}
	
	public HashMap<String, Object> selectRsturtMngId(String rsturtNm, String addr){
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("rsturtNm", rsturtNm);
		paramMap.put("addr", addr);
		return (HashMap)query.selectMap("selectRsturtMngId", paramMap, "main");
	}
	
	public int updateRsturtInfo(RsturtInfoForm rsturtInfoForm) {
		return query.update("main.updateRsturtInfo", rsturtInfoForm);
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
