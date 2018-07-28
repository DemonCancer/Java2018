package entity;

public class User {
	private int id;
	private String username;
	private String userpass;
	private boolean role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public User(String username, String userpass, boolean role) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.role = role;
	}
	public User() {
		super();
	}
	

}
