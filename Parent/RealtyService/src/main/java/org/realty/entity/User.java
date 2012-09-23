package org.realty.entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="user")
public class User {

	private Long userId;
	private String name;
	private String password;
	private String phoneNumber;
    private Boolean admin;
    private List<Advert> adverts;
    private List<Comment> comments;


	public User() {

	}
    @Id
    @Column(name="user_id")
    @GeneratedValue

	public Long getUserId() {
		return userId;
	}
    @Column(name="name")
	public String getName() {
		return name;
	}

    @Column(name="password")
	public String getPassword() {
		return password;
	}
    @Column(name="phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setUserId(Long newVal) {
		userId = newVal;
	}

	public void setName(String newVal) {
		name = newVal;
	}

	public void setPassword(String newVal) {
		password = newVal;
	}


	public void setPhoneNumber(String newVal) {
		phoneNumber = newVal;
	}

    @Column(name="admin")
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }


	@Override
	public boolean equals(Object other) {
		return (other instanceof User) && (userId != null) ? userId
				.equals(((User) other).userId) : (other == this);
	}

	@Override
	public int hashCode() {
		return (userId != null) ? (this.getClass().hashCode() + userId
				.hashCode()) : super.hashCode();
	}

	@Override
	public String toString() {
		return String.format(
				"User[userId=%d,name=%s,password=%s,phoneNumber=%s]", userId,
				name, password, phoneNumber);
	}

    @OneToMany(mappedBy="user")
    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    @OneToMany(mappedBy="user")
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}