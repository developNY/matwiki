package com.gwangple.matwiki.mypage.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwangple.matwiki.mypage.dto.AddWshDto;
import com.gwangple.matwiki.mypage.dto.ShowMineDto;
import com.gwangple.matwiki.mypage.dto.ShowWshDto;

/**
 * 20`7.08.15
 * @author ������
 *
 */
public class MypageDao {
	private static final Logger logger = LoggerFactory.getLogger(MypageDao.class);
	@Resource(name="sqlSession")
	private SqlSession query;
	public void setQuery(SqlSession query) {
		this.query = query;
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int writeWsh(AddWshDto addWshDto) throws SQLException {
		int testStr = query.insert("mypage.addWsh");

		return testStr;
    }
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> showWsh(ShowWshDto showWshDto) throws SQLException {
		
		List<Map<String, Object>> list = query.selectList("mypage.showWsh");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
    }
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> showMine(ShowMineDto showMineDto) throws SQLException {
		
		List<Map<String, Object>> list = query.selectList("mypage.showMine");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
    }
}