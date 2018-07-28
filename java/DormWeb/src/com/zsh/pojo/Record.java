package com.zsh.pojo;

import java.util.Date;

public class Record {
	private int recordId;
	private String studentNumber;
	private String studentName;
	private int dormBuildId;
	private Date date;
	private String dormName;
	private String detail;
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public Record() {
		super();
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Record(String studentNumber, String studentName, int dormBuildId,
			Date date, String dormName, String detail) {
		super();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.dormBuildId = dormBuildId;
		this.date = date;
		this.dormName = dormName;
		this.detail = detail;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	
	
	
}

