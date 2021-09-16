package com.educacionit.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.educacionit.entidades.Usuario;
import com.educacionit.enumerados.Mensajes;
import com.educacionit.implementaciones.mariadb.UsuarioImplementacion;

/**
 * Servlet implementation class LoginValidar
 */
public class LoginValidar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioImplementacion usuarioImplementacion;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidar() {
        super();
   
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	//Instanciamos los objetos despues del constructor
    	this.usuarioImplementacion = new UsuarioImplementacion();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean cerrarSesion = Boolean.valueOf(request.getParameter("cerrarSesion"));
		
		if(cerrarSesion && request.getSession().getId() != null) {
			//cerramos la sesion
			request.getSession().invalidate();
			request.setAttribute("Mensaje", Mensajes.CERRAR_SESION);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		HttpSession sesion = null;
		String paginaRedireccion = "login.jsp";
		Usuario usuario = usuarioImplementacion.buscar(correo);
	
		if((null != usuario) && usuario.getClave().equals(clave)) {
			//credenciales correctas
			if(!usuario.isActivo()) {
				request.setAttribute("Mensaje",Mensajes.USUARIO_INACTIVO);
				
			}else {
				sesion = request.getSession();
				sesion.setAttribute("usuario",usuario);
				paginaRedireccion = "index.jsp";
			}	
		}else {
			request.setAttribute("Mensaje", Mensajes.CREDENCIALES_INCORRECTAS);
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(paginaRedireccion);
		requestDispatcher.forward(request, response);
		
		
	}
}