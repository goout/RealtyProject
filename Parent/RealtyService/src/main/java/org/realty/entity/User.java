package org.realty.entity;


import javax.persistence.*;


@Entity
@Table(name="user")
public class User {

	private Long userId;
	private String name;
	private String password;
	private String phoneNumber;
    private Boolean admin;


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

    @Column(name="passwordt")
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




}