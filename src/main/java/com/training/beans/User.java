package com.training.beans;

public class User {
	public static String userName; 
	public static  String password;
	
	public User() {}
	
	public User(String userName, String password) {
		super();
		User.userName = userName;
		User.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		User.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + "]";
	} 
	
	
}
