package com.cashonline.enumerator;

public enum LoanMessages implements Message {

	INSERT_OK ("¡Prestamo creado con exito!"),
	INSERT_MANY_OK ("¡Prestamos creados con exito!"),
	INSERT_ERR ("Ha ocurrido un error al crear el prestamo."),
	INSERT_MANY_ERR ("Ha ocurrido un error al crear los prestamos."),
	
	DELETE_OK ("¡Prestamo borrado con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar el prestamo."),
	
	GET_OK ("¡Prestamo encontrado!"),
	GET_MANY_OK ("¡Prestamos encontrados!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar el prestamo."),
	GET_MANY_ERR ("No se han encontrado prestamos."),
	
	ERR_NOT_EXISTS ("El prestamo seleccionado no existe.");
	
	private final String msg;

	private LoanMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
