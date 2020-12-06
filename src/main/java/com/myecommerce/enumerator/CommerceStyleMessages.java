package com.myecommerce.enumerator;

public enum CommerceStyleMessages implements Message {

	INSERT_OK ("¡Estilo creado con exito!"),
	INSERT_ERR ("Ha ocurrido un error al crear el estilo."),
	
	DELETE_OK ("¡Estilo borrado con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar el estilo."),
	
	GET_OK ("¡Estilo encontrado!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar el estilo."),

	GET_MANY_OK ("¡Estilos encontrados!"),
	GET_MANY_ERR ("No se han encontrado estilos."),
	
	ERR_NOT_EXISTS ("El estilo seleccionado no existe.");
	
	private final String msg;

	private CommerceStyleMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
