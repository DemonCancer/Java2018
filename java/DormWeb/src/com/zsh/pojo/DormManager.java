package com.zsh.pojo;

public class DormManager {
	private int dormManId;
	private String userName;
	private String password;
	private int dormBuildId;
	private String name;
	private String sex;
	private String tel;
	public int getDormManId() {
		return dormManId;
	}
	public void setDormManId(int dormManId) {
		this.dormManId = dormManId;
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
	public int getDormBuildId() {
		return dormBuildId;
	}
	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
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
	public DormManager(String userName, String password, int dormBuildId,
			String name, String sex, String tel) {
		super();
		this.userName = userName;
		this.password = password;
		this.dormBuildId = dormBuildId;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
	}
	public DormManager() {
		super();
	}
	
	

}
