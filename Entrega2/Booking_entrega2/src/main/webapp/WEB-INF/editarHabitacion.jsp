<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="icon" href="img/icono-booking.png" type="image/png">
    <link rel="stylesheet" href="css/registro.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
    <header>
		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>
    <div id="main">
        <div id="contenedor-central">
            <form id="formulario-registro" action="EditAccommodationServlet.do?idH=${habitacion.id}" method="post">
                <h1>Editar habitación: ${habitacion.name}</h1>
                
                <label for="nombre"><span>Nombre</span></label><br>
                <input type="text" name="nombre" value="${habitacion.name}" required><br>
                
                <label for="descripcion-hab"><span>Descripción</span></label><br>
                <input type="text" name="descripcion-hab" value="${habitacion.description}" required><br>
    
                <label for="precio-hab"><span>Precio</span></label><br>
                <input type="number" id="precio-hab" name="precio-hab" step="1" value="${habitacion.price}"><br>
                
                <label for="disponibles"><span>Nº habitaciones disponibles</span></label><br>
                <input type="number" id="disponibles" name="disponibles" step="1" value="${habitacion.numAccommodations}"><br>
                
                <input type="hidden" id="idA" name="idA" value="${habitacion.idp}">
                
                <p><input type="submit" value="Guardar cambios"></p>
            </form>

        </div>

    </div>
  
</body>