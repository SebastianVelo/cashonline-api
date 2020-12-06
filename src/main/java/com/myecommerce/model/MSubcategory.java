package com.myecommerce.model;

import com.myecommerce.entity.Subcategory;

public class MSubcategory extends Model {
	private long idCategory;
	private String name;

	public MSubcategory(Subcategory subcategory) {
		this.id = subcategory.getId();
		this.idCategory = subcategory.getIdCategory();
		this.name = subcategory.getName();
	}

	public MSubcategory(long id, long idCommerce, String name, short order) {
		super();
		this.id = id;
		this.idCategory = idCommerce;
		this.name = name;
	}

	public long getIdCommerce() {
		return idCategory;
	}

	public void setIdCommerce(long idCommerce) {
		this.idCategory = idCommerce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
