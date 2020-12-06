package com.myecommerce.model;

import com.myecommerce.entity.Cart;

public class MCart extends Model {
	private long idCommerce;
	private long idUser;
	
	public MCart (Cart cart) {
		this.id = cart.getId();
		this.idCommerce = cart.getIdCommerce();
		this.idUser = cart.getIdUser();
	}

	public MCart(long id, long idCommerce, long idUser) {
		super();
		this.id = id;
		this.idCommerce = idCommerce;
		this.idUser = idUser;
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
