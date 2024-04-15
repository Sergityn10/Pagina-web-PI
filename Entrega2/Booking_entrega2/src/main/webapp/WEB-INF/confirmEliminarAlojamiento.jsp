<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmaci�n Eliminar Alojamiento</title>
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
            
            <h1>Eliminar alojamiento: ${alojamiento.name}</h1>

            <p class="p-aux">Informaci�n que se va a eliminar:</p>

            <p class="datos">Nombre: <span class="resaltado">${alojamiento.name}</span></p>
            <p class="datos">Ciudad: <span class="resaltado">${alojamiento.city}</span></p></p>
            <p class="datos">Direcci�n: <span class="resaltado">${alojamiento.address}</span></p></p>
            <p class="datos">Tel�fono: <span class="resaltado">${alojamiento.telephone}</span></p></p>
            <p class="datos">Distancia al centro: <span class="resaltado">${alojamiento.centerDistance}</span></p></p>
            <p class="datos">Descripci�n: <span class="resaltado">${alojamiento.description}</span></p></p>

            <p class="p-aux">�Est�s seguro de que quieres eliminar el alojamiento? Esta acci�n es irreversible</p>

            <form action="DeletePropertyServlet.do" method="post">
            	<input type="hidden" name="idA" value="${alojamiento.id}">
                <p><input type="submit" value="Eliminar alojamiento"></p>
            </form>
            
            

        </div>

    </div>

</body>
</html>