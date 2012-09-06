package org.realty.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="city")
public class City {
    private long cityId;
    private String cityName;
    private List<District> districts;

    public City(){}

    @Id
    @Column(name="cityId")
    @GeneratedValue
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "city_district", joinColumns = {
            @JoinColumn(name = "cityId") }, inverseJoinColumns = {
            @JoinColumn(name = "districtId") })
    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
