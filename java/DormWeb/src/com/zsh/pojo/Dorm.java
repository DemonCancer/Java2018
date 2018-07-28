package com.zsh.pojo;

public class Dorm {
	private int dormId;
	private int dormBuildId;
	private String dormName;
	private String dormType;
	private String dormNum;
	private String dormTel;
	
	
	
	
	public Dorm() {
		super();
	}
	public Dorm(int dormBuildId, String dormName, String dormType,
			String dormNum, String dormTel) {
		super();
		this.dormBuildId = dormBuildId;
		this.dormName = dormName;
		this.dormType = dormType;
		this.dormNum = dormNum;
		this.dormTel = dormTel;
	}
	public int getDormId() {
		return dormId;
	}
	public void setDormId(int dormId) {
		this.dormId = dormId;
	}
	public int getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public String getDormType() {
		return dormType;
	}
	public void setDormType(String dormType) {
		this.dormType = dormType;
	}
	public String getDormNum() {
		return dormNum;
	}
	public void setDormNum(String dormNum) {
		this.dormNum = dormNum;
	}
	public String getDormTel() {
		return dormTel;
	}
	public void setDormTel(String dormTel) {
		this.dormTel = dormTel;
	}
	
	

}
