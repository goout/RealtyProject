package org.realty.entity;

import javax.persistence.*;

@Entity
@Table(name="adress")
public class Adress {

    private Long adressId;
    private int apartmentNum;
    private Long cityId;
    private Long districtId;
    private int houseNum;
    private Long streetId;


    public Adress() {
    }

    @Id
    @Column(name="adressId")
    @GeneratedValue
    public Long getAdressId() {
        return adressId;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
    }
    @Column(name="apartmentNum")
    public int getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(int apartmentNum) {
        this.apartmentNum = apartmentNum;
    }
    @Column(name="cityId")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    @Column(name="districtId")
    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }
    @Column(name="houseNum")
    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }
    @Column(name="streetId")
    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }
}
