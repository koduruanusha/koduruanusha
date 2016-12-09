package com.model;

public class User {
	
	public User(String userid) {
		super();
		this.userid = userid;
	}

	private String userid,password,email;

	public User(String userid, String password, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", email="
				+ email + "]";
	}
	
	
	
	

}
