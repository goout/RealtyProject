package org.realty.entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "advert")
public class Advert {

    private String addedDate;
    private String category;
    private int rooms;
    private Long adressId;
    private int coast;
    private String description;
    private Long advertId;
    private Long userId;
    private List<Comment> comments;
    private Adress adress;


    public Advert() {

    }

    @Column(name = "added_date")
    public String getAddedDate() {
        return addedDate;
    }


    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    @Column(name = "coast")
    public int getCoast() {
        return coast;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }


    @Id
    @Column(name = "advert_id")
    @GeneratedValue
    public Long getAdvertId() {
        return advertId;
    }

    public void setAddedDate(String addedDate) {

        this.addedDate = addedDate;
    }


    public void setCategory(String newVal) {
        this.category = newVal;
    }

    public void setCoast(int newVal) {
        this.coast = newVal;
    }

    public void setDescription(String newVal) {
        this.description = newVal;
    }


    public void setAdvertId(Long newVal) {
        this.advertId = newVal;
    }

    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "rooms")
    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

     // @Column(name="adressId")
    @Transient
    public Long getAdressId() {
        return adressId;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
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
        return String.format("Advert[addedDate=%s,category=%s,rooms=%s,adressId=%d," +
                " coast=%d, description=%s, advertId=%d, userId=%d]",
                addedDate, category, getRooms(), getAdressId(), coast, description, advertId, userId);
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "advert_id", referencedColumnName = "advert_id")
    })
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "adressId", referencedColumnName = "adressId")
    })
    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}