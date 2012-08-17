package org.realty;

public class UsrInfo {

	private String UserName = "";
	private boolean LoginFlag = false;
	private boolean isAdmin = false;

	public UsrInfo() {
	}

	public void Login(String TheUser) {
		LoginFlag = true;
		setUserName(TheUser);
	}

	public void Logout() {
		LoginFlag = false;
		setUserName("");

	}
		
	public String IsLogin() {
		if (LoginFlag)
			return "true";
		return "false";
	}

	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
}
