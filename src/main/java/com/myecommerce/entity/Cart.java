package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="CART")
@Entity
public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private long id;

	@Column(name="ID_COMMERCE")
	private long idCommerce;
	
	@Column(name="ID_USER")
	private long idUser;

	public Cart() {
		
	}

	public Cart(long id, long idCommerce, long idUser) {
		super();
		this.id = id;
		this.idCommerce = idCommerce;
		this.idUser = idUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCommerce() {
		return idCommerce;
	}

	public void setIdCommerce(long idCommerce) {
		this.idCommerce = idCommerce;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

}
