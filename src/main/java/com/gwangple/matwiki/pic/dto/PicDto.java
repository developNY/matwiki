package com.gwangple.matwiki.pic.dto;

/**
 * 사진 DTO
 * @author sukhwan
 *
 */
public class PicDto {
	/**
	 * 메뉴 번호
	 */
	private String mnuCd;
	/**
	 * 메뉴 설명
	 */
	private String picDic;
	/**
	 * 사진 경로
	 */
	private String picFrontPath;
	/**
	 * 사진 뒷 경로
	 */
	private String picBackPath;
	/**
	 * 사진 파일명
	 */
	private String picFileNm;
	/**
	 * 맛집 관리 번호
	 */
	private String rsturtMngId;
	/**
	 * 생성자
	 */
	private String createId;
	/**
	 * 수정자
	 */
	private String uptId;
	/**
	 * 생성 날짜
	 */
	private String createDt;
	/**
	 * 수정 날짜
	 */
	private String uptDt;
	
	/**
	 * 썸네일 여부
	 */
	private String thumbYn;
	public String getMnuCd() {
		return mnuCd;
	}
	public void setMnuCd(String mnuCd) {
		this.mnuCd = mnuCd;
	}
	public String getPicDic() {
		return picDic;
	}
	public void setPicDic(String picDic) {
		this.picDic = picDic;
	}
	public String getPicFileNm() {
		return picFileNm;
	}
	public void setPicFileNm(String picFileNm) {
		this.picFileNm = picFileNm;
	}
	public String getRsturtMngId() {
		return rsturtMngId;
	}
	public void setRsturtMngId(String rsturtMngId) {
		this.rsturtMngId = rsturtMngId;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	public String getUptId() {
		return uptId;
	}
	public void setUptId(String uptId) {
		this.uptId = uptId;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getUptDt() {
		return uptDt;
	}
	public void setUptDt(String uptDt) {
		this.uptDt = uptDt;
	}
	public String getThumbYn() {
		return thumbYn;
	}
	public void setThumbYn(String thumbYn) {
		this.thumbYn = thumbYn;
	}
	public String getPicFrontPath() {
		return picFrontPath;
	}
	public void setPicFrontPath(String picFrontPath) {
		this.picFrontPath = picFrontPath;
	}
	public String getPicBackPath() {
		return picBackPath;
	}
	public void setPicBackPath(String picBackPath) {
		this.picBackPath = picBackPath;
	}
	
}
