package com.myecommerce.model;

import com.myecommerce.entity.Purchase;

public class MPurchase extends Model {

	private long idCart;
	private long idProduct;
	private int price;
	private int quantity;

	public MPurchase(Purchase purchase) {
		this.id = purchase.getId();
		this.idCart = purchase.getIdCart();
		this.idProduct = purchase.getIdProduct();
		this.price = purchase.getPrice();
		this.quantity = purchase.getQuantity();
	}
	
	public MPurchase(long id, long idCart, long idProduct, int price, int quantity) {
		super();
		this.id = id;
		this.idCart = idCart;
		this.idProduct = idProduct;
		this.price = price;
		this.quantity = quantity;
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
