package com.gwangple.matwiki.mypage.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class AddWshDto {

	@NotEmpty
	private String userId;//userId
	
	@NotEmpty
	private String rsturtMngId;//rsturtMngId
	
	@NotEmpty
	private String createDt;//createDt

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the rsturtMngId
	 */
	public String getRsturtMngId() {
		return rsturtMngId;
	}

	/**
	 * @param rsturtMngId the rsturtMngId to set
	 */
	public void setRsturtMngId(String rsturtMngId) {
		this.rsturtMngId = rsturtMngId;
	}

	/**
	 * @return the createDt
	 */
	public String getCreateDt() {
		return createDt;
	}

	/**
	 * @param createDt the createDt to set
	 */
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddWshDto [userId=" + userId + ", rsturtMngId=" + rsturtMngId + ", createDt=" + createDt + "]";
	}
	
}
