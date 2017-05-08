package com.gwangple.matwiki.service;

import java.sql.SQLException;

import javax.annotation.Resource;

import com.gwangple.matwiki.dao.HomeDao;

public class HomeService {
	
	@Resource(name="homeDao")
	private HomeDao homeDao;
	public void setHomeDao(HomeDao homeDao) {
		this.homeDao = homeDao;
	}
	
	public String getTest(){
		try {
			return homeDao.test();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
}
