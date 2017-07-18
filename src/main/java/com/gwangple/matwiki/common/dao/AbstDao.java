package com.gwangple.matwiki.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 공통(추상) DAO
 * @author sukhwan
 *
 */
public class AbstDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	/**
	 * 데이터 삽입
	 * @param queryId : Query Id
	 * @param param     : 파라미터
	 * @return
	 */
	public Object insert(String queryId,Object param){
		return sqlSession.insert(queryId,param);
	}
	
	/**
	 * 데이터 한개 선택
	 * @param queryId : Query Id
	 * @return
	 */
	public Object select(String queryId){
		return sqlSession.selectOne(queryId);
	}

	/**
	 * 데이터 한개 선택
	 * @param queryId : Query Id
	 * @param param     : 파라미터
	 * @return
	 */
	public Object selectOne(String queryId,Object param){
		return sqlSession.selectOne(queryId,param);
	}
	
	/**
	 * 데이터 리스트 선택
	 * @param queryId  : Query Id
	 * @return
	 */
	public Object selectList(String queryId){
		return sqlSession.selectList(queryId);
	}
	/**
	 * 데이터 리스트 선택 
	 * @param queryId : Query Id
	 * @param param     : 파라미터
	 * @return
	 */
	public Object selectList(String queryId,Object param){
		return sqlSession.selectList(queryId,param);
	}
	
	/**
	 * 데이터 수정
	 * @param queryId : Query Id
	 * @param param     : 파라미터
	 * @return
	 */
	public Object update(String queryId,Object param){
		return sqlSession.update(queryId,param);
	}
	
	/**
	 * 데이터 삭제
	 * @param queryId : Query Id
	 * @param param     : 파라미터
	 * @return
	 */
	public Object delete(String queryId,Object param){
		return sqlSession.delete(queryId,param);
	}
	
}
