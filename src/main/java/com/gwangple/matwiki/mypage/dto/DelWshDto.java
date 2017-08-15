package com.gwangple.matwiki.mypage.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class DelWshDto {

	@NotEmpty
	private String USER_ID;
	
	@NotEmpty
	private String RSTURT_MNG_ID;
	
	

	/**
	 * @return the uSER_ID
	 */
	public String getUSER_ID() {
		return USER_ID;
	}



	/**
	 * @param uSER_ID the uSER_ID to set
	 */
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}



	/**
	 * @return the rSTURT_MNG_ID
	 */
	public String getRSTURT_MNG_ID() {
		return RSTURT_MNG_ID;
	}



	/**
	 * @param rSTURT_MNG_ID the rSTURT_MNG_ID to set
	 */
	public void setRSTURT_MNG_ID(String rSTURT_MNG_ID) {
		RSTURT_MNG_ID = rSTURT_MNG_ID;
	}



	@Override
	public String toString() {
		return "DelWshDto [USER_ID=" + USER_ID + ", RSTURT_MNG_ID=" + RSTURT_MNG_ID + "]";
	}
	
}
