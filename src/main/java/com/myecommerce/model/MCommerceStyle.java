package com.myecommerce.model;

import com.myecommerce.entity.CommerceStyle;

public class MCommerceStyle extends Model {
	private long idCommerce;
	private String main;
	private String secondary;
	private String background;
	
	public MCommerceStyle (CommerceStyle commerceStyle) {
		this.id = commerceStyle.getId();
		this.idCommerce = commerceStyle.getIdCommerce();
		this.main = commerceStyle.getMain();
		this.secondary = commerceStyle.getSecondary();
		this.background = commerceStyle.getBackground();
	}

	public MCommerceStyle(long id, long idCommerce, String main, String secondary, String background) {
		super();
		this.id = id;
		this.idCommerce = idCommerce;
		this.main = main;
		this.secondary = secondary;
		this.background = background;
	}

	public long getIdCommerce() {
		return idCommerce;
	}

	public void setIdCommerce(long idCommerce) {
		this.idCommerce = idCommerce;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

}
