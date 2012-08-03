package org.realty;

public class User {

	private long id;
	private String name;
	private String password;
	private String phoneNumber;

	public User() {

	}

	public long getid() {
		return id;
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

	public void setid(long newVal) {
		id = newVal;
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