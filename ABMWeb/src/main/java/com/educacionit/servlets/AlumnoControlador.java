package com.educacionit.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educacionit.entidades.Alumno;
import com.educacionit.entidades.Documento;
import com.educacionit.enumerados.Mensajes;
import com.educacionit.implementaciones.mariadb.AlumnoImplementacion;
import com.educacionit.interfaces.Fechas;

/**
 * Servlet implementation class AlumnoControlador
 */

@WebServlet("/alumnoABM")
public class AlumnoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AlumnoImplementacion alumnoImplementacion;  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoControlador() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	alumnoImplementacion = new AlumnoImplementacion();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//eliminar el alumno
		String tipoDocumento = request.getParameter("tipoDocumento");
		String numeroDocumento = request.getParameter("numeroDocumento");
		Documento documento = new Documento(tipoDocumento, numeroDocumento);
		Alumno alumno = new Alumno();
		alumno.setDocumento(new Documento(tipoDocumento, numeroDocumento));
		
		if(alumnoImplementacion.eliminar(alumno)) {
			request.setAttribute("Mensaje", Mensajes.ELIMINAR_REGISTRO);
        }else {
        	request.setAttribute("Mensaje", Mensajes.ERROR);
        }

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tipo = request.getParameter("tipoDocumento");
			String numero = request.getParameter("numeroDocumento");
			String descripcion = request.getParameter("descripcion");
			Date fechaNacimiento = Fechas.getStringAFechaSQL(request.getParameter("fechaNacimiento"));
			Boolean activo = Boolean.valueOf(request.getParameter("activo"));
			
			Alumno alumno = new Alumno();
			alumno.setDocumento(new Documento(tipo, numero));
			alumno.setDescripcion(descripcion);
			alumno.setFechaNacimiento(fechaNacimiento);
			alumno.setActivo(activo);
			
			Boolean guardo = alumnoImplementacion.guardar(alumno);
			request.setAttribute("Mensaje", guardo?Mensajes.GUARDAR_REGISTRO:Mensajes.ERROR);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}