package com.hlx07.domain;

public class User {
	private String username;
	private String userpass;
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
	public User(String username, String userpass) {
		this.username = username;
		this.userpass = userpass;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
}
