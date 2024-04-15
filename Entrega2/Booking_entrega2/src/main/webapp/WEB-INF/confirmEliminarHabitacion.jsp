<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmación Eliminar Habitación</title>
    <link rel="icon" href="img/icono-booking.png" type="image/png">
    <link rel="stylesheet" href="css/eliminarUsuario.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
    <header>
		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>
    <div id="main">
        <div id="contenedor-central">
            
            <h1>Eliminar habitación: ${habitacion.name}</h1>

            <p class="p-aux">Información que se va a eliminar:</p>

            <p class="datos">Nombre: <span class="resaltado">${habitacion.name}</span></p>
            <p class="datos">Descripción: <span class="resaltado">${habitacion.description}</span></p></p>
            <p class="datos">Precio: <span class="resaltado">${habitacion.price}</span></p></p>
            <p class="datos">Nº habitaciones disponibles: <span class="resaltado">${habitacion.numAccommodations}</span></p></p>            

            <p class="p-aux">¿Estás seguro de que quieres eliminar la habitaón? Esta acción es irreversible</p>

            <form action="DeleteAccommodationServlet.do" method="post">
            	<input type="hidden" name="idH" value="${habitacion.id}">
                <p><input type="submit" value="Eliminar habitación"></p>
            </form>
            
            

        </div>

    </div>

</body>
</html>