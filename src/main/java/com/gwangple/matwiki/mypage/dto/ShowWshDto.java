package com.gwangple.matwiki.mypage.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ShowWshDto {

	@NotEmpty
	private String RSTURT_MNG_ID;
	
	@NotEmpty
	private String PIC_SEQ;
	
	@NotEmpty
	private String LNG;
	
	@NotEmpty
	private String LAT;
	
	@NotEmpty
	private String RNK;
	
	@NotEmpty
	private String RSTURT_ID;
	
	@NotEmpty
	private String SIDO;
	
	@NotEmpty
	private String GUGUN;
	
	@NotEmpty
	private String RI;
	
	@NotEmpty
	private String DONG;
	
	@NotEmpty
	private String BLDG;
	
	@NotEmpty
	private String BUNJI;
	
	@NotEmpty
	private String REW_SEQ;
	
	@NotEmpty
	private String REW_NM;
	
	@NotEmpty
	private String CREATE_ID;
	
	@NotEmpty
	private String ADDR_SEQ;
	
	

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



	/**
	 * @return the pIC_SEQ
	 */
	public String getPIC_SEQ() {
		return PIC_SEQ;
	}



	/**
	 * @param pIC_SEQ the pIC_SEQ to set
	 */
	public void setPIC_SEQ(String pIC_SEQ) {
		PIC_SEQ = pIC_SEQ;
	}



	/**
	 * @return the lNG
	 */
	public String getLNG() {
		return LNG;
	}



	/**
	 * @param lNG the lNG to set
	 */
	public void setLNG(String lNG) {
		LNG = lNG;
	}



	/**
	 * @return the lAT
	 */
	public String getLAT() {
		return LAT;
	}



	/**
	 * @param lAT the lAT to set
	 */
	public void setLAT(String lAT) {
		LAT = lAT;
	}



	/**
	 * @return the rNK
	 */
	public String getRNK() {
		return RNK;
	}



	/**
	 * @param rNK the rNK to set
	 */
	public void setRNK(String rNK) {
		RNK = rNK;
	}



	/**
	 * @return the rSTURT_ID
	 */
	public String getRSTURT_ID() {
		return RSTURT_ID;
	}



	/**
	 * @param rSTURT_ID the rSTURT_ID to set
	 */
	public void setRSTURT_ID(String rSTURT_ID) {
		RSTURT_ID = rSTURT_ID;
	}



	/**
	 * @return the sIDO
	 */
	public String getSIDO() {
		return SIDO;
	}



	/**
	 * @param sIDO the sIDO to set
	 */
	public void setSIDO(String sIDO) {
		SIDO = sIDO;
	}



	/**
	 * @return the gUGUN
	 */
	public String getGUGUN() {
		return GUGUN;
	}



	/**
	 * @param gUGUN the gUGUN to set
	 */
	public void setGUGUN(String gUGUN) {
		GUGUN = gUGUN;
	}



	/**
	 * @return the rI
	 */
	public String getRI() {
		return RI;
	}



	/**
	 * @param rI the rI to set
	 */
	public void setRI(String rI) {
		RI = rI;
	}



	/**
	 * @return the dONG
	 */
	public String getDONG() {
		return DONG;
	}



	/**
	 * @param dONG the dONG to set
	 */
	public void setDONG(String dONG) {
		DONG = dONG;
	}



	/**
	 * @return the bLDG
	 */
	public String getBLDG() {
		return BLDG;
	}



	/**
	 * @param bLDG the bLDG to set
	 */
	public void setBLDG(String bLDG) {
		BLDG = bLDG;
	}



	/**
	 * @return the bUNJI
	 */
	public String getBUNJI() {
		return BUNJI;
	}



	/**
	 * @param bUNJI the bUNJI to set
	 */
	public void setBUNJI(String bUNJI) {
		BUNJI = bUNJI;
	}



	/**
	 * @return the rEW_SEQ
	 */
	public String getREW_SEQ() {
		return REW_SEQ;
	}



	/**
	 * @param rEW_SEQ the rEW_SEQ to set
	 */
	public void setREW_SEQ(String rEW_SEQ) {
		REW_SEQ = rEW_SEQ;
	}



	/**
	 * @return the rEW_NM
	 */
	public String getREW_NM() {
		return REW_NM;
	}



	/**
	 * @param rEW_NM the rEW_NM to set
	 */
	public void setREW_NM(String rEW_NM) {
		REW_NM = rEW_NM;
	}



	/**
	 * @return the cREATE_ID
	 */
	public String getCREATE_ID() {
		return CREATE_ID;
	}



	/**
	 * @param cREATE_ID the cREATE_ID to set
	 */
	public void setCREATE_ID(String cREATE_ID) {
		CREATE_ID = cREATE_ID;
	}



	/**
	 * @return the aDDR_SEQ
	 */
	public String getADDR_SEQ() {
		return ADDR_SEQ;
	}



	/**
	 * @param aDDR_SEQ the aDDR_SEQ to set
	 */
	public void setADDR_SEQ(String aDDR_SEQ) {
		ADDR_SEQ = aDDR_SEQ;
	}



	@Override
	public String toString() {
		return "ShowWshDto [RSTURT_MNG_ID=" + RSTURT_MNG_ID + ", PIC_SEQ=" + PIC_SEQ + ", LNG=" + LNG 
				+ ",LAT =" + LAT + ", RNK=" + RNK + ", RSTURT_ID=" + RSTURT_ID + ", SIDO=" + SIDO 
				+ ", GUGUN=" + GUGUN + ", RI=" + RI + ", DONG=" + DONG + ", BLDG=" + BLDG + ", BUNJI=" + BUNJI
				+ ", REW_SEQ=" + REW_SEQ + ", REW_NM=" + REW_NM + ", CREATE_ID=" + CREATE_ID
				+ ", ADDR_SEQ=" + ADDR_SEQ + "]";
	}
	
}
