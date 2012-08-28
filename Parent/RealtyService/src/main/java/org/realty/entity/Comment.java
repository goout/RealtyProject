package org.realty.entity;

public class Comment {

	//private String commentatorName;
	private int commentId;
	private String text;
	private Long userId;
	private Long advertId;
	

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAdvertId() {
		return advertId;
	}

	public void setAdvertId(Long advertId) {
		this.advertId = advertId;
	}

}