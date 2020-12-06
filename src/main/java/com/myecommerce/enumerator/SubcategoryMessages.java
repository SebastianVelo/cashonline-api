package com.myecommerce.enumerator;

public enum SubcategoryMessages implements Message {

	INSERT_OK ("¡Subcategoria creado con exito!"),
	INSERT_ERR ("Ha ocurrido un error al crear la subcategoria."),
	
	DELETE_OK ("¡Subcategoria borrada con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar la subcategoria."),
	
	GET_OK ("¡Subcategoria encontrada!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar la subcategoria."),

	GET_MANY_OK ("¡Subcategorias encontradas!"),
	GET_MANY_ERR ("No se han encontrado subcategorias."),
	
	ERR_NOT_EXISTS ("La subcategoria seleccionada no existe.");
	
	private final String msg;

	private SubcategoryMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
