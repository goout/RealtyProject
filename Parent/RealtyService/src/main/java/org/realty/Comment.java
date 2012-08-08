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

	public int getCommentId() {
		return commentId;
	}

	public String getText() {
		return text;
	}

/*	public void setcommentatorName(String newVal) {
		commentatorName = newVal;
	}*/

	public void setCommentId(int newVal) {
		commentId = newVal;
	}

	public void setText(String newVal) {
		text = newVal;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAdvertId() {
		return advertId;
	}

	public void setAdvertId(int advertId) {
		this.advertId = advertId;
	}

}