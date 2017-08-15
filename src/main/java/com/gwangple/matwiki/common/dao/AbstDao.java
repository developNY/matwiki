package com.gwangple.matwiki.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ����(�߻�) DAO
 * @author sukhwan
 *
 */
public class AbstDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	/**
	 * ������ ����
	 * @param queryId : Query Id
	 * @param param     : �Ķ����
	 * @return
	 */
	public Object insert(String queryId,Object param){
		return sqlSession.insert(queryId,param);
	}
	
	/**
	 * ������ �Ѱ� ����
	 * @param queryId : Query Id
	 * @return
	 */
	public Object select(String queryId){
		return sqlSession.selectOne(queryId);
	}

	/**
	 * ������ �Ѱ� ����
	 * @param queryId : Query Id
	 * @param param     : �Ķ����
	 * @return
	 */
	public Object selectOne(String queryId,Object param){
		return sqlSession.selectOne(queryId,param);
	}
	
	/**
	 * ������ ����Ʈ ����
	 * @param queryId  : Query Id
	 * @return
	 */
	public Object selectList(String queryId){
		return sqlSession.selectList(queryId);
	}
	/**
	 * ������ ����Ʈ ���� 
	 * @param queryId : Query Id
	 * @param param     : �Ķ����
	 * @return
	 */
	public Object selectList(String queryId,Object param){
		return sqlSession.selectList(queryId,param);
	}
	
	/**
	 * ������ ����
	 * @param queryId : Query Id
	 * @param param     : �Ķ����
	 * @return
	 */
	public Object update(String queryId,Object param){
		return sqlSession.update(queryId,param);
	}
	
	/**
	 * ������ ����
	 * @param queryId : Query Id
	 * @param param     : �Ķ����
	 * @return
	 */
	public Object delete(String queryId,Object param){
		return sqlSession.delete(queryId,param);
	}
	
}
