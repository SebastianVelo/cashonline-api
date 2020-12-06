package com.myecommerce.model;

import com.myecommerce.entity.Category;

public class MCategory extends Model {
	private long idCommerce;
	private String name;
	private short order;

	public MCategory(Category category) {
		this.id = category.getId();
		this.idCommerce = category.getIdCommerce();
		this.name = category.getName();
		this.order = category.getOrder();
	}

	public MCategory(long id, long idCommerce, String name, short order) {
		super();
		this.id = id;
		this.idCommerce = idCommerce;
		this.name = name;
		this.order = order;
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
