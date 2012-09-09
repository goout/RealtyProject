package org.realty.entity;


import javax.persistence.*;

@Entity
@Table(name = "street")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Street {

    private long streetId;
    private String streetName;
    private long districtId;

    public Street(){

    }
    @Id
    @Column(name="streetId")
    @GeneratedValue
    public long getStreetId() {
        return streetId;
    }

    public void setStreetId(long streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }
}
