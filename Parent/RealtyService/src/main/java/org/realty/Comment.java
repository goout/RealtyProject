package org.realty;

public class Comment {

	private String commentatorName;
	private long id;
	private String text;

	public Comment() {
	}

	public String getcommentatorName() {
		return commentatorName;
	}

	public long getid() {
		return id;
	}

	public String gettext() {
		return text;
	}

	public void setcommentatorName(String newVal) {
		commentatorName = newVal;
	}

	public void setid(long newVal) {
		id = newVal;
	}

	public void settext(String newVal) {
		text = newVal;
	}

}