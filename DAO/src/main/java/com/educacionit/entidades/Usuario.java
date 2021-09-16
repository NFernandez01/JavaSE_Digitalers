package com.educacionit.entidades;

import com.educacionit.exepciones.ExecpcionPatrones;
import com.educacionit.interfaces.Patrones;

/**
 * 
 * @author Nahuel
 * 
 */

public class Usuario {
	private String correo;
	private String clave;
	private boolean activo;
	
	
	public Usuario() {
		
		
	}
	public Usuario(String correo, String clave, boolean activo) throws ExecpcionPatrones {
		super();
		setCorreo(correo);
		setClave(clave);
		this.activo = activo;
	}
	
	
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * este es el seteo del correo del usuario
	 * @param correo
	 * @throws ExecpcionPatrones 
	 */
	public void setCorreo(String correo) throws ExecpcionPatrones {
		if(!Patrones.esCorreo(correo)) {
			throw new ExecpcionPatrones(1);
		}
		this.correo = correo;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) throws ExecpcionPatrones {
		if(!Patrones.esClave(clave)) {
			throw new ExecpcionPatrones(2);
		}
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