package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="USER")
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private long id;

	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	public User() {
		
	}
	
	public User(long id, String userName, String password, String email) {
		super();
		this.id = id;
		this.username = userName;
		this.password = password;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
}
