package com.zsh.pojo;

public class Student {

	private int studentId;
	private String stuNum;
	private String password;
	private String name;
	private String dormName;
	private int dormBuildId;
	private String sex;
	private String tel;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public int getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Student(String stuNum, String password, String name,
			String dormName, int dormBuildId, String sex, String tel) {
		super();
		this.stuNum = stuNum;
		this.password = password;
		this.name = name;
		this.dormName = dormName;
		this.dormBuildId = dormBuildId;
		this.sex = sex;
		this.tel = tel;
	}
	public Student() {
		super();
	}
	
	
}
