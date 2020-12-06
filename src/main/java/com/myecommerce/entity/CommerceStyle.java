package com.myecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="COMMERCE_STYLE")
@Entity
public class CommerceStyle implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private long id;

	@Column(name="ID_COMMERCE")
	private long idCommerce;

	@Column(name="MAIN")
	private String main;

	@Column(name="SECONDARY")
	private String secondary;
	
	@Column(name="BACKGROUND")
	private String background;
	
	public CommerceStyle () {
		
	}

	public CommerceStyle(long id, long idCommerce, String main, String secondary, String background) {
		super();
		this.id = id;
		this.idCommerce = idCommerce;
		this.main = main;
		this.secondary = secondary;
		this.background = background;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
