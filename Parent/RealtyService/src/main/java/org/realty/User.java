package org.realty;

public class User {

	private int userId;
	private String name;
	private String password;
	private String phoneNumber;

	public User() {

	}

	public int getuserId() {
		return userId;
	}

	public String getname() {
		return name;
	}

	public String getpassword() {
		return password;
	}

	public String getphoneNumber() {
		return phoneNumber;
	}

	public void setuserId(int newVal) {
		userId = newVal;
	}

	public void setname(String newVal) {
		name = newVal;
	}

	public void setpassword(String newVal) {
		password = newVal;
	}

	public void setphoneNumber(String newVal) {
		phoneNumber = newVal;
	}

}