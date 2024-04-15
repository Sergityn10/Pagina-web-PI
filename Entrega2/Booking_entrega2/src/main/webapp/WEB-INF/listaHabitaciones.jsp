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
        
            <nav id="cabecera-nav">
                <div class="title">
                    <a href="">
                        <h1>Booking.com</h1>
                    </a>
                </div>
                
                <div id="botones-header">
                    <button class="seleccion" type="button" title="Selecciona la moneda" oncl aria-expanded="false">EUR</button> <!-- Botón de selección de la moneda-->
                    <button class="seleccion" type="button" title="Selecciona tu idioma" aria-expanded="false">
                        <img id="img-bandera" src="img/Banderas/spain.png" alt="">
                    </button>
                    <span class="seleccion">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M464 256A208 208 0 1 0 48 256a208 208 0 1 0 416 0zM0 256a256 256 0 1 1 512 0A256 256 0 1 1 0 256zm169.8-90.7c7.9-22.3 29.1-37.3 52.8-37.3h58.3c34.9 0 63.1 28.3 63.1 63.1c0 22.6-12.1 43.5-31.7 54.8L280 264.4c-.2 13-10.9 23.6-24 23.6c-13.3 0-24-10.7-24-24V250.5c0-8.6 4.6-16.5 12.1-20.8l44.3-25.4c4.7-2.7 7.6-7.7 7.6-13.1c0-8.4-6.8-15.1-15.1-15.1H222.6c-3.4 0-6.4 2.1-7.5 5.3l-.4 1.2c-4.4 12.5-18.2 19-30.6 14.6s-19-18.2-14.6-30.6l.4-1.2zM224 352a32 32 0 1 1 64 0 32 32 0 1 1 -64 0z"/></svg>
                    </span> 
                    
                </div>
                
            </nav>

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