package com.educacionit.entidades;

public class Usuario {
	private String correo;
	private String clave;
	private boolean activo;
	
	
	public Usuario() {
		
		
	}
	public Usuario(String correo, String clave, boolean activo) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.activo = activo;
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "Usuario [ " + correo + ", " + clave + ", " + activo + "]";
	}
}