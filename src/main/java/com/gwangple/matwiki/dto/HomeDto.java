package com.gwangple.matwiki.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class HomeDto {

	@NotEmpty
	private String param1;
	
	@NotEmpty @Size(min=4, max=8)
	private String param2;
	
	private String param3;
	
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	
	@Override
	public String toString() {
		return "HomeDto [param1=" + param1 + ", param2=" + param2 + ", param3=" + param3 + "]";
	}
	
}
