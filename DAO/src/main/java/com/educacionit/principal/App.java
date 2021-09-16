package com.educacionit.principal;

import java.text.ParseException;

import com.educacionit.entidades.Alumno;
import com.educacionit.entidades.Documento;
import com.educacionit.entidades.Usuario;
import com.educacionit.exepciones.ExecpcionPatrones;
import com.educacionit.implementaciones.mariadb.AlumnoImplementacion;
import com.educacionit.implementaciones.mariadb.UsuarioImplementacion;
import com.educacionit.interfaces.Fechas;

public class App {

	public static void main(String[] args) throws ParseException {
		/*AlumnoImplementacion impl = new AlumnoImplementacion();
		for (Alumno alumno : impl.listar()) {
			System.out.println(alumno);
		}	
		
		Alumno alumno1 = new Alumno();
		alumno1.setDocumento(new Documento("DNI","01"));
		alumno1.setDescripcion("Octavio Robleto");
		alumno1.setFechaNacimiento(Fechas.getStringAFecha("16/03/1998"));
		alumno1.setActivo(false);
		
		impl.guardar(alumno1);
		impl.eliminar(alumno1);*/

		try {
			Usuario usuario1 = new Usuario("user4@gmail.com","User4abcd",true);
			UsuarioImplementacion impl = new UsuarioImplementacion();
			
			impl.guardar(usuario1);
			
			for(Usuario usuario : impl.listar()) {
				System.out.println(usuario);
			}
			 
		} catch (ExecpcionPatrones e) {
			e.printStackTrace();
		}
	}
}