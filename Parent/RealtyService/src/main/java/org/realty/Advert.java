package org.realty;

import java.sql.Date;

public class Advert {

	private Date addedDate;
	private String category;
	private String district;
	private String adress;
	private int coast;
	private String description;
	private Long advertId;
	private Long userId;
    private String city;

	public Advert() {

	}

	public Date getAddedDate() {
		return addedDate;
	}

	public String getAdress() {
		return adress;
	}

	public String getCategory() {
		return category;
	}

	public int getCoast() {
		return coast;
	}

	public String getDescription() {
		return description;
	}

	public String getDistrict() {
		return district;
	}

	public Long getAdvertId() {
		return advertId;
	}

	public void setAddedDate(Date newVal) {
		addedDate = newVal;
	}

	public void setAdress(String newVal) {
		adress = newVal;
	}

	public void setCategory(String newVal) {
		category = newVal;
	}

	public void setCoast(int newVal) {
		coast = newVal;
	}

	public void setDescription(String newVal) {
		description = newVal;
	}

	public void setDistrict(String newVal) {
		district = newVal;
	}

	public void setAdvertId(Long newVal) {
		advertId = newVal;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


	@Override
	public boolean equals(Object other) {
		return (other instanceof Advert) && (advertId != null) ? advertId
				.equals(((Advert) other).advertId) : (other == this);
	}

	@Override
	public int hashCode() {
		return (advertId != null) ? (this.getClass().hashCode() + advertId
				.hashCode()) : super.hashCode();
	}

	
	 @Override
	    public String toString() {
	        return String.format("Advert[addedDate=%s,category=%s,district=%s,adress=%s," +
	        		" coast=%d, description=%s, advertId=%d, userId=%d]", 
	            addedDate, category, district, adress, coast, description, advertId, userId);
	    }



}