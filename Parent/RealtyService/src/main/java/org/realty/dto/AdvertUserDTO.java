package org.realty.dto;


import java.sql.Date;

public class AdvertUserDTO {

    private Date addedDate;
    private String category;
    private int coast;
    private String description;
    private Long advertId;
    private Long advertUserId;

    private String userName;


    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public Long getAdvertUserId() {
        return advertUserId;
    }

    public void setAdvertUserId(Long advertUserId) {
        this.advertUserId = advertUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
