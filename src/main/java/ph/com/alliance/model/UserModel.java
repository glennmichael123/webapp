package ph.com.alliance.model;

import ph.com.alliance.entity.User;

public class UserModel {
	
	private String userid;
	private String fname;
	private String lname;
	private String gender;
	private int age;
	
	public UserModel(){}
	
	public UserModel(User pUser) {
		this.fname = pUser.getFname();
		this.lname = pUser.getLname();
		this.gender = pUser.getGender();
		this.age = pUser.getAge();
		this.userid = pUser.getUid();
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}


	@Override
    public String toString() {
        return "User {" + ", fname=" + fname + ", lname=" + lname + '}';

    } 
}
