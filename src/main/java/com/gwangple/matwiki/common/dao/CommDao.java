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
	 * 시퀀스
	 * @return
	 * @throws SQLException
	 */
	public String getSeqNo(String seqName) throws SQLException {
		
		String seqNo = null;
		
		if( "name1".equals(seqName) )
		{
			seqNo = CommonUtils.getPaddingLeft((String)query.selectOne("common.getName1SeqNo"), 10);
		}
		else if( "name2".equals(seqName) )
		{
			seqNo = CommonUtils.getPaddingLeft((String)query.selectOne("common.getName2SeqNo"), 10);
		}
		
		return seqNo;
    }
	
}
