package com.myapp.spring.model;

public class AdminData {
	String username;
	private String password;

//	public UserData(String username, String password) {
//		this.username = username;
//		this.password = password;
//	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "AdminData [username=" + username + ", password=" + password + "]";
	}
}
