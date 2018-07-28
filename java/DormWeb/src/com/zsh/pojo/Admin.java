package com.zsh.pojo;

public class Admin {
	private int adminId;
	private String userName;
	private String password;
	private String name;
	private String sex;
	private String tel;
	
	public Admin() {
		super();
	}
	public Admin(String userName, String password, String name, String sex,
			String tel) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	

}
