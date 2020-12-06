package com.myecommerce.enumerator;

public enum ProductMessages implements Message {

	INSERT_OK ("¡Producto creado con exito!"),
	INSERT_ERR ("Ha ocurrido un error al crear el producto."),
	
	DELETE_OK ("¡Producto borrado con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar el producto."),
	
	GET_OK ("¡Producto encontrado!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar el producto."),

	GET_MANY_OK ("¡Productos encontrados!"),
	GET_MANY_ERR ("No se han encontrado productos."),
	
	ERR_NOT_EXISTS ("El producto seleccionado no existe.");
	
	private final String msg;

	private ProductMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
