package org.realty.dto;


import org.realty.entity.Comment;
import org.realty.entity.User;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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
    private String phoneNumber;


    private int apartmentNum;
    private Long adressCityId;
    private Long adressDistrictId;
    private int houseNum;
    private Long adressStreetId;

    private String cityName;

    private String districtName;

    private String streetName;

    private List<Comment> comments;
    private List<User> users;




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

    public int getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(int apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    public Long getAdressCityId() {
        return adressCityId;
    }

    public void setAdressCityId(Long adressCityId) {
        this.adressCityId = adressCityId;
    }

    public Long getAdressDistrictId() {
        return adressDistrictId;
    }

    public void setAdressDistrictId(Long adressDistrictId) {
        this.adressDistrictId = adressDistrictId;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public Long getAdressStreetId() {
        return adressStreetId;
    }

    public void setAdressStreetId(Long adressStreetId) {
        this.adressStreetId = adressStreetId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
