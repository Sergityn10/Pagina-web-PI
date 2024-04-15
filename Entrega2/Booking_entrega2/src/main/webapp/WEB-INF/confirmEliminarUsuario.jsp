<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
    <link rel="icon" href="img/icono-booking.png" type="image/png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/eliminarUsuario.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
    <header>
		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>
    <div id="main">
        <div id="contenedor-central">
            
            <h1>Eliminar usuario: ${user.name}</h1>

            <p class="p-aux">Información que se va a eliminar:</p>

			<p class="datos">Email: <span class="resaltado">${user.email}</span></p></p>
            <p class="datos">Nombre: <span class="resaltado">${user.name}</span></p>
            <p class="datos">Apellidos: <span class="resaltado">${user.surname}</span></p></p>

            <p class="p-aux">¿Estás seguro de que quieres eliminar el usuario? Esta acción es irreversible</p>

            <form action="DeleteUserServlet.do" method="post">
                <p><input type="submit" value="Eliminar usuario"></p>
            </form>
            

        </div>

    </div>

</body>