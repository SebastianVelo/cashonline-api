package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="USER_DATA")
@Entity
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private long id;

	@Column(name="ID_USER")
	private long idUser;

	@Column(name="NAME")
	private String name;

	@Column(name="LASTNAME")
	private String lastname;

	@Column(name="PHONE")
	private String phone;

	@Column(name="ADDRESS")
	private String address;

	public UserData() {
		
	}
	
	public UserData(long id, long idUser, String name, String lastname, String phone, String address) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
