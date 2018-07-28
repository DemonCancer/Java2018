package entity;

import java.sql.Date;

public class Student {
	private int id;
	private boolean role;
	private String userno;
	private String username;
	private String userpass;
	private int age;
	private boolean sex;
	private Date birthday;
	private String profession;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date date) {
		this.birthday = date;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public Student(boolean role, String userno, String username,
			String userpass, int age, boolean sex, Date birthday,
			String profession) {
		super();
		this.role = role;
		this.userno = userno;
		this.username = username;
		this.userpass = userpass;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.profession = profession;
	}
	public Student() {
		super();
	}
	

}
