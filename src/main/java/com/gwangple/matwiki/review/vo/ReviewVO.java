package com.gwangple.matwiki.review.vo;

import java.util.Date;

public class ReviewVO {
	
	String RSTURT_MNG_ID;
	String USER_ID;
	String REW_CONT;
	String GRD;
	Integer REW_SEQ;
	String UPT_ID;
	Date CREATE_DT;
	Date UPT_DT;
	
	public String getRSTURT_MNG_ID() {
		return RSTURT_MNG_ID;
	}
	public void setRSTURT_MNG_ID(String rSTURT_MNG_ID) {
		RSTURT_MNG_ID = rSTURT_MNG_ID;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getREW_CONT() {
		return REW_CONT;
	}
	public void setREW_CONT(String rEW_CONT) {
		REW_CONT = rEW_CONT;
	}
	public String getGRD() {
		return GRD;
	}
	public void setGRD(String gRD) {
		GRD = gRD;
	}
	public Integer getREW_SEQ() {
		return REW_SEQ;
	}
	public void setREW_SEQ(Integer rEW_SEQ) {
		REW_SEQ = rEW_SEQ;
	}
	public String getUPT_ID() {
		return UPT_ID;
	}
	public void setUPT_ID(String uPT_ID) {
		UPT_ID = uPT_ID;
	}
	public Date getCREATE_DT() {
		return CREATE_DT;
	}
	public void setCREATE_DT(Date cREATE_DT) {
		CREATE_DT = cREATE_DT;
	}
	public Date getUPT_DT() {
		return UPT_DT;
	}
	public void setUPT_DT(Date uPT_DT) {
		UPT_DT = uPT_DT;
	}
	@Override
	public String toString() {
		return "ReviewVO [RSTURT_MNG_ID=" + RSTURT_MNG_ID + ", USER_ID=" + USER_ID + ", REW_CONT=" + REW_CONT + ", GRD="
				+ GRD + ", REW_SEQ=" + REW_SEQ + ", UPT_ID=" + UPT_ID + ", CREATE_DT=" + CREATE_DT + ", UPT_DT="
				+ UPT_DT + "]";
	}
	
	
}
