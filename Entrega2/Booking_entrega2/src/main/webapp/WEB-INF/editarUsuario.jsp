<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EditarPerfil</title>
    <link rel="icon" href="img/icono-booking.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registro.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
   <header>
		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>
    <div id="main">
        <div id="contenedor-central">
            <form id="formulario-registro" action="EditUserServlet.do" method="post">
                <h1>Editar Perfil: ${user.name}</h1>
                
                <label for="nombre"><span>Nombre</span></label><br>
                <input type="text" name="nombre" value="${user.name}" required><br>
                
                <label for="apellidos"><span>Apellidos</span></label><br>
                <input type="text" name="apellidos" value="${user.surname}" required><br>
                
                <label for="email"><span>Correo electrónico</span></label><br>
                <input type="email" name="email" value="${user.email}" required><br>
                
                <label for="password"><span>Contraseña</span></label><br>
                <input type="password" name="password" value="${user.password}" required><br>
                
                <p><input type="submit" value="Guardar cambios"></p>
            </form>

            
            <div id="enlaces-inferiores">
                <a href="DeleteUserServlet.do">Eliminar cuenta</a>
            </div>

        </div>

    </div>
  
</body>
</html>