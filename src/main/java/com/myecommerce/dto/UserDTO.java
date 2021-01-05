package com.myecommerce.dto;

import com.myecommerce.entity.User;
import com.myecommerce.entity.UserData;

public class UserDTO {

	private long id;	
	private String username;
	private String password;
	private String email;	
	private String name;
	private String lastname;
	private String phone;
	private String address;

	public UserDTO () {

	}

	public UserDTO(User user, UserData userData) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.name = userData.getName();
		this.lastname = userData.getLastname();
		this.phone = userData.getPhone();
		this.address = userData.getAddress();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
