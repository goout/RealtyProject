package org.realty;

public class Comment {

	private String commentatorName;
	private int commentId;
	private String text;

	public Comment() {
	}

	public String getcommentatorName() {
		return commentatorName;
	}

	public int getcommentId() {
		return commentId;
	}

	public String gettext() {
		return text;
	}

	public void setcommentatorName(String newVal) {
		commentatorName = newVal;
	}

	public void setcommentId(int newVal) {
		commentId = newVal;
	}

	public void settext(String newVal) {
		text = newVal;
	}

}