package com.myecommerce.enumerator;

public enum CommerceMessages implements Message {

	INSERT_OK ("¡Comercio creado con exito!"),
	INSERT_ERR_PATH ("La URL ya ha sido utilizada."),
	INSERT_ERR ("Ha ocurrido un error al crear el comercio."),
	
	DELETE_OK ("¡Comercio borrado con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar el comercio."),
	
	GET_OK ("¡Comercio encontrado!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar el comercio."),

	GET_MANY_OK ("¡Comercios encontrados!"),
	GET_MANY_ERR ("No se han encontrado comercios."),
	
	ERR_NOT_EXISTS ("El comercio seleccionado no existe.");
	
	private final String msg;

	private CommerceMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
