package com.myecommerce.model;

import com.myecommerce.entity.Commerce;

public class MCommerce extends Model {
	private long idUser;
	private String name;
	private String path;
	private String description;
	
	public MCommerce (Commerce commerce) {	
		this.id = commerce.getId();
		this.idUser = commerce.getIdUser();
		this.name = commerce.getName();
		this.path = commerce.getPath();
		this.description = commerce.getDescription();
	}

	public MCommerce(long id, long idUser, String name, String path, String description) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.name = name;
		this.path = path;
		this.description = description;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
