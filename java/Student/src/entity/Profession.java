package entity;

public class Profession {
	private int id;
	private String profession;
	public Profession(String profession) {
		super();
		this.profession = profession;
	}
	public Profession() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
}
