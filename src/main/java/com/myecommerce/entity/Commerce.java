package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="COMMERCE")
@Entity
public class Commerce implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private long id;

	@Column(name="ID_USER")
	private long idUser;

	@Column(name="NAME")
	private String name;

	@Column(name="PATH")
	private String path;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	public Commerce () {
		
	}

	public Commerce(long id, long idUser, String name, String path, String description) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.name = name;
		this.path = path;
		this.description = description;
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
