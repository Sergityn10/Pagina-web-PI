<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservas y viajes</title>
    <link rel="icon" href="img/icono-booking.png" type="image/png">
    <link rel="stylesheet" href="css/listaHabitaciones.css">
</head>
<body>
    <div class="container-header">
        <header>

		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>

                 
    </div>

    <div class="container-reservas">
        <section id="titulo">
            <h2>Alojamiento: ${alojamiento.name} - Habitaciones</h2>

            <a id="nueva-hab" href="EditPropertyServlet.do?idp=${alojamiento.id }">Añadir nueva habitación</a>

        </section>
        <main>
            
            <c:forEach var="habitacion" items="${listaHabitaciones}">
            	<div class="box-habitacion">
	                <img  class="imagen-habitacion" src="img/Alojamientos/hotelLujo.jpg" alt="img-habitacion">
	                <section class="atributos">
	                    <p class="nombre-hab">Nombre habitación: ${habitacion.name}</p>
	                    <p>Descripción: ${habitacion.description}</p>
	                    <p>Precio/noche: ${habitacion.price}€</p>
	                    <p>Número de habitaciones disponibles: ${habitacion.numAccommodations}</p>
	                    <div class="box-enlaces">
	                        <a class="enlace-editar" href="EditAccommodationServlet.do?ida=${habitacion.id}">Editar habitación</a>
	                        <a class="enlace-eliminar" href="DeleteAccommodationServlet.do?ida=${habitacion.id}">Eliminar habitación</a>
                    	</div>
	                </section>
            	</div>		
            </c:forEach> 
            
        </main>
    </div>
    
    
</body>
</html>