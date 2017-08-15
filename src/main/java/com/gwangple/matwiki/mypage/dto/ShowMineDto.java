package com.gwangple.matwiki.mypage.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ShowMineDto {

	@NotEmpty
	private String rsturtMngId;
	
	@NotEmpty
	private String picSeq;
	
	@NotEmpty
	private String lng;
	
	@NotEmpty
	private String lat;
	
	@NotEmpty
	private String rnk;
	
	@NotEmpty
	private String rsturtId;
	
	@NotEmpty
	private String sido;
	
	@NotEmpty
	private String gugun;
	
	@NotEmpty
	private String ri;
	
	@NotEmpty
	private String dong;
	
	@NotEmpty
	private String bldg;
	
	@NotEmpty
	private String bunji;
	
	@NotEmpty
	private String rewSeq;
	
	@NotEmpty
	private String rewNm;
	
	@NotEmpty
	private String createId;
	
	@NotEmpty
	private String addrSeq;

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
	 * @return the picSeq
	 */
	public String getPicSeq() {
		return picSeq;
	}

	/**
	 * @param picSeq the picSeq to set
	 */
	public void setPicSeq(String picSeq) {
		this.picSeq = picSeq;
	}

	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}

	/**
	 * @param lng the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}

	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @return the rnk
	 */
	public String getRnk() {
		return rnk;
	}

	/**
	 * @param rnk the rnk to set
	 */
	public void setRnk(String rnk) {
		this.rnk = rnk;
	}

	/**
	 * @return the rsturtId
	 */
	public String getRsturtId() {
		return rsturtId;
	}

	/**
	 * @param rsturtId the rsturtId to set
	 */
	public void setRsturtId(String rsturtId) {
		this.rsturtId = rsturtId;
	}

	/**
	 * @return the sido
	 */
	public String getSido() {
		return sido;
	}

	/**
	 * @param sido the sido to set
	 */
	public void setSido(String sido) {
		this.sido = sido;
	}

	/**
	 * @return the gugun
	 */
	public String getGugun() {
		return gugun;
	}

	/**
	 * @param gugun the gugun to set
	 */
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	/**
	 * @return the ri
	 */
	public String getRi() {
		return ri;
	}

	/**
	 * @param ri the ri to set
	 */
	public void setRi(String ri) {
		this.ri = ri;
	}

	/**
	 * @return the dong
	 */
	public String getDong() {
		return dong;
	}

	/**
	 * @param dong the dong to set
	 */
	public void setDong(String dong) {
		this.dong = dong;
	}

	/**
	 * @return the bldg
	 */
	public String getBldg() {
		return bldg;
	}

	/**
	 * @param bldg the bldg to set
	 */
	public void setBldg(String bldg) {
		this.bldg = bldg;
	}

	/**
	 * @return the bunji
	 */
	public String getBunji() {
		return bunji;
	}

	/**
	 * @param bunji the bunji to set
	 */
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}

	/**
	 * @return the rewSeq
	 */
	public String getRewSeq() {
		return rewSeq;
	}

	/**
	 * @param rewSeq the rewSeq to set
	 */
	public void setRewSeq(String rewSeq) {
		this.rewSeq = rewSeq;
	}

	/**
	 * @return the rewNm
	 */
	public String getRewNm() {
		return rewNm;
	}

	/**
	 * @param rewNm the rewNm to set
	 */
	public void setRewNm(String rewNm) {
		this.rewNm = rewNm;
	}

	/**
	 * @return the createId
	 */
	public String getCreateId() {
		return createId;
	}

	/**
	 * @param createId the createId to set
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}

	/**
	 * @return the addrSeq
	 */
	public String getAddrSeq() {
		return addrSeq;
	}

	/**
	 * @param addrSeq the addrSeq to set
	 */
	public void setAddrSeq(String addrSeq) {
		this.addrSeq = addrSeq;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShowMineDto [rsturtMngId=" + rsturtMngId + ", picSeq=" + picSeq + ", lng=" + lng + ", lat=" + lat
				+ ", rnk=" + rnk + ", rsturtId=" + rsturtId + ", sido=" + sido + ", gugun=" + gugun + ", ri=" + ri
				+ ", dong=" + dong + ", bldg=" + bldg + ", bunji=" + bunji + ", rewSeq=" + rewSeq + ", rewNm=" + rewNm
				+ ", createId=" + createId + ", addrSeq=" + addrSeq + "]";
	}
	
	
}
