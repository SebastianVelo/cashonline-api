package com.myecommerce.enumerator;

public enum ProductImgMessages implements Message {

	INSERT_OK ("¡Imagen de imagen de producto creado con exito!"),
	INSERT_ERR ("Ha ocurrido un error al crear el imagen de producto."),
	
	DELETE_OK ("¡Imagen de imagen de producto borrado con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar el imagen de producto."),
	
	GET_OK ("¡Imagen de imagen de producto encontrado!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar el imagen de producto."),

	GET_MANY_OK ("¡Imagen de imagen de productos encontrados!"),
	GET_MANY_ERR ("No se han encontrado imagen de productos."),
	
	ERR_NOT_EXISTS ("El imagen de producto seleccionado no existe.");
	
	private final String msg;

	private ProductImgMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
