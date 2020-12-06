package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="PURCHASE")
@Entity
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private long id;

	@Column(name="ID_CART")
	private long idCart;
	
	@Column(name="ID_PRODUCT")
	private long idProduct;

	@Column(name="PRICE")
	private int price;
	
	@Column(name="QUANTITY")
	private int quantity;

	public Purchase() {
		
	}
	
	public Purchase(long id, long idCart, long idProduct, int price, int quantity) {
		super();
		this.id = id;
		this.idCart = idCart;
		this.idProduct = idProduct;
		this.price = price;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCart() {
		return idCart;
	}

	public void setIdCart(long idCart) {
		this.idCart = idCart;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
