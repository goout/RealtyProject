package org.realty;

public class Comment {

	//private String commentatorName;
	private int commentId;
	private String text;
	private int userId;
	private int advertId;
	

	public Comment() {
	}

/*	public String getcommentatorName() {
		return commentatorName;
	}*/

	public int getcommentId() {
		return commentId;
	}

	public String gettext() {
		return text;
	}

/*	public void setcommentatorName(String newVal) {
		commentatorName = newVal;
	}*/

	public void setcommentId(int newVal) {
		commentId = newVal;
	}

	public void settext(String newVal) {
		text = newVal;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public int getadvertId() {
		return advertId;
	}

	public void setadvertId(int advertId) {
		this.advertId = advertId;
	}

}