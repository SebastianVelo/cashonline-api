package com.myecommerce.dto;

import java.util.List;

import com.myecommerce.entity.Product;
import com.myecommerce.entity.ProductImg;

public class ProductDTO  {
	private long id;
	private long idSubcategory;
	private String name;
	private String description;
	private int stock;
	private int price;
	private String currency;
	private boolean showInHome;
	private List<ProductImg> imgs;

	public ProductDTO() {
		
	}

	public ProductDTO(Product product, List<ProductImg> imgs) {
		this.id = product.getId();
		this.idSubcategory = product.getIdSubcategory();
		this.name = product.getName();
		this.description = product.getDescription();
		this.stock = product.getStock();
		this.price = product.getPrice();
		this.currency = product.getCurrency();
		this.showInHome = product.isShowInHome();
		this.imgs = imgs;
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


	public List<ProductImg> getImgs() {
		return imgs;
	}


	public void setImgs(List<ProductImg> imgs) {
		this.imgs = imgs;
	}

	public boolean isShowInHome() {
		return showInHome;
	}


	public void setShowInHome(boolean showInHome) {
		this.showInHome = showInHome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		for(ProductImg productImg : this.imgs) {
			productImg.setIdProduct(id);
		}
	}
}
