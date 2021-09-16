package com.educacionit.interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface Fechas {
	
	String FECHA_SQL = "yyyy-MM-dd";
	String FECHA_USUARIO = "dd/MM/yyyy";
	
	/**
	 * este metodo recibe un objeto Java.Util.Date y retorna un String con formato dd-MM-yyyy
	 * @param fecha
	 * @return String
	 */
	static String getFechaAString(Date fecha) {
		return new SimpleDateFormat(FECHA_USUARIO).format(fecha);
	}
	
	/**
	 * Este metodo recibe un string con formato dd-MM-yyyy y retorna un objeto de tipo Date
	 * @param fecha
	 * @return java.util.date
	 * @throws ParseException
	 */
	static Date getStringAFecha(String fecha) throws ParseException {
		return new SimpleDateFormat(FECHA_USUARIO).parse(fecha);
	}
	
	/**
	 * este metodo recibe un objeto Java.Util.Date y retorna un String con formato yyyy-MM-dd
	 * @param fecha
	 * @return String
	 */
	static String getfechaSQLAString(Date fecha) {
		return new SimpleDateFormat(FECHA_SQL).format(fecha);
	}
	
	/**
	 * Este metodo recibe un string con formato yyyy-MM-dd y retorna un objeto de tipo Date
	 * @param fecha
	 * @return java.util.date
	 * @throws ParseException
	 */
	static Date getStringAFechaSQL(String fecha) throws ParseException {
		return new SimpleDateFormat(FECHA_SQL).parse(fecha);
	}
}