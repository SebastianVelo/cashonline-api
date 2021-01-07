package com.cashonline.enumerator;

public enum UserDataMessages implements Message {

	INSERT_OK ("¡Datos de usuario creado con exito!"),
	INSERT_ERR ("Ha ocurrido un error al crear el datos de usuario."),
	
	DELETE_OK ("¡Datos de usuario borrado con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar el datos de usuario."),
	
	GET_OK ("¡Datos de usuario encontrado!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar el datos de usuario."),

	ERR_NOT_EXISTS ("Datos de usuario seleccionado no existe.");
	
	private final String msg;

	private UserDataMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
