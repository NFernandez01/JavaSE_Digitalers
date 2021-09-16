package com.educacionit.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Patrones {
	String PATRON_CORREO = "([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))";
	String PATRON_CLAVE = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$";
	
	static boolean esCorreo(String correo) {
		Pattern patron = Pattern.compile(PATRON_CORREO);
		Matcher comparacion = patron.matcher(correo);
		return comparacion.find();
	}
	
	static boolean esClave(String clave) {
		Pattern patron = Pattern.compile(PATRON_CLAVE);
		Matcher comparacion = patron.matcher(clave);
		return comparacion.find();
	}
}