package com.gwangple.matwiki.login.dao;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.gwangple.matwiki.common.dto.UserInfoDto;
import com.gwangple.matwiki.login.dto.JoinMembershipDto;
import com.gwangple.matwiki.login.dto.LoginDto;

public class LoginDao {
    
	@Resource(name="sqlSession")
	private SqlSession query;
	public void setQuery(SqlSession query) {
		this.query = query;
	}
	
	/**
	 * 로그인 체크
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> loginCheck(LoginDto loginDto) throws SQLException {
		return query.selectOne("login.loginCheck", loginDto);
    }
	
	/**
	 * 등록된 ID 유무 확인
	 * @param userId
	 * @return "Y" or "N"
	 * @throws SQLException
	 */
	public String getUserIdYn(String userId) throws SQLException {
        return query.selectOne("login.getUserIdYn", userId);
	}
	
	/**
	 * 회원가입
	 * @param joinMembershipDTO
	 * @return 1 : true
	 * @throws SQLException
	 */
	public int insJoinMembership(JoinMembershipDto joinMembershipDto) throws SQLException {
	    return query.insert("login.insJoinMembership", joinMembershipDto);
	}
	
	/**
	 * 비회원정보를 저장한다
	 * @param userInfoDto
	 * @return
	 * @throws SQLException
	 */
	public int setNonUserInfo(UserInfoDto userInfoDto) throws SQLException {
	    return query.insert("login.setNonUserInfo", userInfoDto);
	}
	
	/**
	 * 비회원정보를 가져온다
	 * @param ipAddr
	 * @return
	 * @throws SQLException
	 */
    public UserInfoDto getNonUserInfo(String ipAddr) throws SQLException {
        return query.selectOne("login.getNonUserInfo", ipAddr);
    }
}
