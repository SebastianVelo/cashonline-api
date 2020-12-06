package com.myecommerce.model;

import com.myecommerce.entity.Product;

public class MProduct extends Model {
	private long idSubcategory;
	private String name;
	private String description;
	private int stock;
	private int price;
	private String currency;
	private String imgs;
	private boolean showInHome;


	public MProduct(Product product) {
		this.id = product.getId();
		this.idSubcategory = product.getIdSubcategory();
		this.name = product.getName();
		this.description = product.getDescription();
		this.stock = product.getStock();
		this.price = product.getPrice();
		this.currency = product.getCurrency();
		this.imgs = product.getImgs();
		this.showInHome = product.isShowInHome();
	}


	public MProduct(long id, long idSubcategory, String name, String description, int stock, int price,
			String currency, String imgs, boolean showInHome) {
		super();
		this.id = id;
		this.idSubcategory = idSubcategory;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.price = price;
		this.currency = currency;
		this.imgs = imgs;
		this.showInHome = showInHome;
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


	public String getImgs() {
		return imgs;
	}


	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public boolean isShowInHome() {
		return showInHome;
	}


	public void setShowInHome(boolean showInHome) {
		this.showInHome = showInHome;
	}
}
