package com.myecommerce.enumerator;

public enum PurchaseMessages implements Message {

	INSERT_OK ("¡Carrito creado con exito!"),
	INSERT_ERR ("Ha ocurrido un error al crear la carrito."),
	
	DELETE_OK ("¡Carrito borrado con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar la carrito."),
	
	GET_OK ("¡Carrito encontrado!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar la carrito."),

	GET_MANY_OK ("¡Carritos encontrados!"),
	GET_MANY_ERR ("No se han encontrado carritos."),
	
	ERR_NOT_EXISTS ("La carrito seleccionada no existe.");
	
	private final String msg;

	private PurchaseMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
