package com.gwangple.matwiki.common.dao;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwangple.matwiki.common.utils.CommonUtils;
import com.gwangple.matwiki.dao.HomeDao;

public class CommDao {
	private static final Logger logger = LoggerFactory.getLogger(HomeDao.class);
	@Resource(name="sqlSession")
	private SqlSession query;
	public void setQuery(SqlSession query) {
		this.query = query;
	}
	
	/**
	 * 시퀀스 등록
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public int insSeqGenerator(String tableName) throws SQLException {
		return query.insert("common.insSeqGenerator", tableName);
	}
	
	/**
	 * 시퀀스 업데이트
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public int updSeqGenerator(String tableName) throws SQLException {
		return query.update("common.setSeqGenerator", tableName);
	}
	
	/**
	 * 시퀀스 가져오기
	 * @return
	 * @throws SQLException
	 */
	public String getSeqGenerator(String tableName) throws SQLException {
		
		String seqNo = null;
		seqNo = (String) query.selectOne("common.getSeqGenerator", tableName);
		return seqNo;
    }
	

	
}
