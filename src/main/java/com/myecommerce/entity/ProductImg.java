package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="PRODUCT_IMG")
@Entity
public class ProductImg implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long id;

	@Column(name="ID_PRODUCT")
	private long idProduct;

	@Column(name="URL")
	private String url;

	public ProductImg() {
	}

	public ProductImg(long id, long idProduct, String url) {
		this.id = id;
		this.idProduct = idProduct;
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
