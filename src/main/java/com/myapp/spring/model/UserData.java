package com.myapp.spring.model;

public class UserData {

	private String username;
	private String password;

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
		return "UserData [username=" + username + ", password=" + password + "]";
	}

}
