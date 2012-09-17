package org.realty.entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "district")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class District {

    private long districtId;
    private String districtName;
    private long cityId;
    private List<Street> streets;

    public District() {

    }

    @Id
    @Column(name = "districtId")
    @GeneratedValue
    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /*    @OneToMany(cascade = CascadeType.ALL)
@JoinTable(name = "district_street", joinColumns = {
 @JoinColumn(name = "districtId") }, inverseJoinColumns = {
 @JoinColumn(name = "streetId") })*/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "districtId", referencedColumnName = "districtId")
    })
    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }

    @Column(name = "cityId")
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }
}
