package com.educacionit.enumerados;

public enum Mensajes {
	CERRAR_SESION("Se a cerrado correctamente la sesion","alertWarning"),
	CREDENCIALES_INCORRECTAS("Credenciales incorrectas","alertWarning"),
	USUARIO_INACTIVO("Usuario inactivo, comuniquese con el administrador","alertWarning"),
	GUARDAR_REGISTRO("Se agrego correctamente el registro","alertSuccess"),
	ELIMINAR_REGISTRO("Se ha eliminado correctamente el registro","alertWarning"),
	ERROR("Ha ocurrido un error inseperado","alertDanger");
	
	private String mensaje;
	private String claseCSS;

	private Mensajes(String mensaje, String claseCSS) {
	this.mensaje = mensaje;
	this.claseCSS = claseCSS;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public String getClaseCSS() {
		return claseCSS;
	}
}