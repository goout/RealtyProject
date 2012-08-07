package org.realty;

import java.sql.Date;

public class Advert {

	private Date addedDate;
	private String adress;
	private String category;
	private int coast;
	private String description;
	private String district;
	private int advertId;
	private int userId;

	public Advert() {

	}

	public Date getaddedDate() {
		return addedDate;
	}

	public String getadress() {
		return adress;
	}

	public String getcategory() {
		return category;
	}

	public int getcoast() {
		return coast;
	}

	public String getdescription() {
		return description;
	}

	public String getdistrict() {
		return district;
	}

	public int getadvertId() {
		return advertId;
	}

	public void setaddedDate(Date newVal) {
		addedDate = newVal;
	}

	public void setadress(String newVal) {
		adress = newVal;
	}

	public void setcategory(String newVal) {
		category = newVal;
	}

	public void setcoast(int newVal) {
		coast = newVal;
	}

	public void setdescription(String newVal) {
		description = newVal;
	}

	public void setdistrict(String newVal) {
		district = newVal;
	}

	public void setadvertId(int newVal) {
		advertId = newVal;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}




}