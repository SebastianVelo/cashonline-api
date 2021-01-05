package com.myecommerce.dto;

import com.myecommerce.entity.Commerce;
import com.myecommerce.entity.CommerceStyle;

public class CommerceDTO {

	private long id;
	private long idUser;
	private String name;
	private String path;
	private String description;
	private CommerceStyle style;

	public CommerceDTO() {

	}
	
	public CommerceDTO(Commerce commerce, CommerceStyle style) {
		this.id = commerce.getId();
		this.idUser = commerce.getIdUser();
		this.name = commerce.getName();
		this.path = commerce.getPath();
		this.description = commerce.getDescription();
		this.style = style;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CommerceStyle getStyle() {
		return style;
	}

	public void setStyle(CommerceStyle style) {
		this.style = style;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		this.style.setIdCommerce(id);
	}

}
