package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="CATEGORY")
@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private long id;

	@Column(name="ID_COMMERCE")
	private long idCommerce;

	@Column(name="NAME")
	private String name;

	@Column(name="ORDER_IN_SITE")
	private short order;

	public Category() {
		
	}

	public Category(long id, long idCommerce, String name, short order) {
		super();
		this.id = id;
		this.idCommerce = idCommerce;
		this.name = name;
		this.order = order;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getOrder() {
		return order;
	}

	public void setOrder(short order) {
		this.order = order;
	}
}
