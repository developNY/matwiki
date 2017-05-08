package com.gwangple.matwiki.main.service;

import javax.annotation.Resource;

import com.gwangple.matwiki.main.dao.MainDao;

public class MainService {
	@Resource(name="mainDao")
	private MainDao mainDao;
	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}
	
	public String getList(){
		try {
			return mainDao.test();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
