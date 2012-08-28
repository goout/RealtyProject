package org.realty.dto;


import java.io.Serializable;
import java.sql.Date;

public class AdvertUserAdressDTO implements Serializable {

    private Date addedDate;
    private String category;
    private Long advertAdressId;
    private int coast;
    private String description;
    private Long advertId;
    private Long advertUserId;
    private int rooms;

    private Long userId;
    private String name;

    private Long adressId;
    private int apartmentNum;
    private Long adressCityId;
    private Long adressDistrictId;
    private int houseNum;
    private Long adressStreetId;

    private long cityId;
    private String cityName;

    private long districtId;
    private String districtName;

    private long streetId;
    private String streetName;




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


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getAdvertAdressId() {
        return advertAdressId;
    }

    public void setAdvertAdressId(Long advertAdressId) {
        this.advertAdressId = advertAdressId;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
