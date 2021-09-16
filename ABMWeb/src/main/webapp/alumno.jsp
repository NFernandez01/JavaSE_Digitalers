<%@page import="com.educacionit.interfaces.Fechas"%>
<%@page import="com.educacionit.entidades.Documento"%>
<%@page import="com.educacionit.implementaciones.mariadb.AlumnoImplementacion"%>
<%@page import="com.educacionit.entidades.Alumno"%>
<%@page import="com.educacionit.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/button.css">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" href="CSS/form.css">

<title>ABM Alumnos</title>
	<%!private AlumnoImplementacion alumnoImplementacion = new AlumnoImplementacion();%>
</head>
<body>

	<header>
		<h1>Digitalers - Educacion IT</h1>
		<img alt="" src="images/logo-it.svg" width="200" height="50">
	</header>
	
	<nav>
		<a href="index.jsp">Lista de Alumno</a>
		<a href="LoginValidar?cerrarSesion=true">Cerrar Sesion</a>
	</nav>
	
<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");

	if(null == usuario){
		response.sendRedirect("login.jsp");
	}
	
	String tipoDocumento = request.getParameter("tipoDocumento");
	String numeroDocumento = request.getParameter("numeroDocumento");
	Boolean editar = Boolean.parseBoolean(request.getParameter("editar"));
	Alumno alumno = null;
	
	if(null != tipoDocumento && null != numeroDocumento && editar){
		alumno = alumnoImplementacion.buscar(new Documento(tipoDocumento,numeroDocumento));
	}
%>

	
	<form action="alumnoABM" method="post">
	
		<%if(!editar){ %>
		<select name="tipoDocumento" required <%= editar? "readonly":"" %>>
			<option value="">Seleccione Un Documento</option>
			<option value="DNI">DNI</option>
			<option value="PAS">PAS</option>
			<option value="LE">LE</option>
			<option value="CI">CI</option>
		</select>
		<%}else{ %>
			
			<input type="text" name="tipoDocumento" value="<%=alumno.getDocumento().getTipo()%>" readonly required>
		
		<%} %>
		<input type="text" name="numeroDocumento" value="<%=editar?alumno.getDocumento().getNumero():""%>"<%=editar?"readonly":"" %> required>
		<input type="text" name="descripcion" value="<%=editar?alumno.getDescripcion():""%>"required>
	    <input type="date" name="fechaNacimiento" value="<%=editar?Fechas.getfechaSQLAString(alumno.getFechaNacimiento()):""%>" required>
	    <select name="activo" required>
	    	<option value="">Seleccione una Opcion</option>
	    	<option value="true"<%=editar && alumno.isActivo()?"selected":"" %>>Activo</option>
	    	<option value="false"<%=editar && alumno.isActivo()?"":"selected" %>>Inactivo</option>
	    </select>
	    
	    <button class="success" type="submit">Enviar</button>
	    <button class="warning" type="reset">Cancelar</button>
	        
	</form>
	
	<footer>Creado por Nahuel Fernandez</footer>
</body>
</html>