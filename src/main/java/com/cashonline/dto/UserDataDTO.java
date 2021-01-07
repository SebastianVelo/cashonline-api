package com.cashonline.dto;

import com.cashonline.entity.UserData;

public class UserDataDTO extends DTO {

	private String name;
	private String lastname;
	private long idUser;

	public UserDataDTO () {

	}

	public UserDataDTO(UserData userData) {
		this.id = userData.getId();
		this.idUser = userData.getIdUser();
		this.name = userData.getName();
		this.lastname = userData.getLastname();
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

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

}
