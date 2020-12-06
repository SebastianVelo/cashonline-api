package com.myecommerce.model;

import com.myecommerce.entity.UserData;

public class MUserData extends Model {
	private long idUser;
	private String name;
	private String lastname;
	private String phone;
	private String address;

	public MUserData(UserData userData) {
		this.idUser = userData.getIdUser();
		this.name = userData.getName();
		this.lastname = userData.getLastname();
		this.phone = userData.getPhone();
		this.address = userData.getAddress();
	}
	
	public MUserData(long id, long idUser, String name, String lastname, String phone, String address) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
}
