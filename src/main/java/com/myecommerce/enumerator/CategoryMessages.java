package com.myecommerce.enumerator;

public enum CategoryMessages implements Message {

	INSERT_OK ("¡Categoria creado con exito!"),
	INSERT_ERR ("Ha ocurrido un error al crear la categoria."),
	
	DELETE_OK ("¡Categoria borrada con exito!"),
	DELETE_ERR ("Ha ocurrido un error al borrar la categoria."),
	
	GET_OK ("¡Categoria encontrada!"),
	GET_ERR ("Ha ocurrido un error al intentar encontrar la categoria."),

	GET_MANY_OK ("¡Categorias encontradas!"),
	GET_MANY_ERR ("No se han encontrado categorias."),
	
	ERR_NOT_EXISTS ("La categoria seleccionada no existe.");
	
	private final String msg;

	private CategoryMessages(String msg) {
        this.msg = msg;
    }
    
	@Override
    public String getMsg() {
        return this.msg;
    }
}
