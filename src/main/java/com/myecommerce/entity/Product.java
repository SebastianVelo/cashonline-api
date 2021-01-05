package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="PRODUCT")
@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;

	@Column(name="ID_SUBCATEGORY")
	private long idSubcategory;

	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="STOCK")
	private int stock;
	
	@Column(name="PRICE")
	private int price;
	
	@Column(name="CURRENCY")
	private String currency;

	@Column(name="SHOW_IN_HOME")
	private boolean showInHome;

	public Product() {
		
	}

	public Product(long id, long idSubcategory, String name, String description, int stock, int price,
			String currency, boolean showInHome) {
		super();
		this.id = id;
		this.idSubcategory = idSubcategory;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.price = price;
		this.currency = currency;
		this.showInHome = showInHome;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public long getIdSubcategory() {
		return idSubcategory;
	}


	public void setIdSubcategory(long idSubcategory) {
		this.idSubcategory = idSubcategory;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public boolean isShowInHome() {
		return showInHome;
	}


	public void setShowInHome(boolean showInHome) {
		this.showInHome = showInHome;
	}

}
