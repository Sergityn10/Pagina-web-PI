<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Alojamiento</title>
    <link rel="stylesheet" href="css/editarAlojamiento.css">
</head>
<body>
    <div id="header">
        <h1>Booking.com</h1>
        <div id="botones-header">
            <img src="img/Banderas/españa.png" alt="Icono España">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M464 256A208 208 0 1 0 48 256a208 208 0 1 0 416 0zM0 256a256 256 0 1 1 512 0A256 256 0 1 1 0 256zm169.8-90.7c7.9-22.3 29.1-37.3 52.8-37.3h58.3c34.9 0 63.1 28.3 63.1 63.1c0 22.6-12.1 43.5-31.7 54.8L280 264.4c-.2 13-10.9 23.6-24 23.6c-13.3 0-24-10.7-24-24V250.5c0-8.6 4.6-16.5 12.1-20.8l44.3-25.4c4.7-2.7 7.6-7.7 7.6-13.1c0-8.4-6.8-15.1-15.1-15.1H222.6c-3.4 0-6.4 2.1-7.5 5.3l-.4 1.2c-4.4 12.5-18.2 19-30.6 14.6s-19-18.2-14.6-30.6l.4-1.2zM224 352a32 32 0 1 1 64 0 32 32 0 1 1 -64 0z"/></svg>
        </div>
    </div>
    <div id="main">
        <div id="contenedor-central">
            <form id="formulario-registro" action="EditPropertyServlet.do?idp=${alojamiento.id}" method="post">
                <h1>Edición Alojamiento</h1>
                
                <label for="nombre"><span>Nombre del Alojamiento</span></label><br>
                <input type="text" id="nombre" name="nombre" value="${alojamiento.name}"><br>

                <label for="ciudad"><span>Ciudad</span></label><br>
                <input type="text" id="ciudad" name="ciudad" value="${alojamiento.city}"><br>
    
                <label for="direccion"><span>Dirección</span></label><br>
                <input type="text" id="direccion" name="direccion" value="${alojamiento.address}"><br>
    
                <label for="telefono"><span>Teléfono</span></label><br>
                <input type="tel" id="telefono" name="telefono" value="${alojamiento.telephone}"><br>
    
                <label for="distancia"><span>Distancia al centro (metros)</span></label><br>
                <input type="number" id="distancia" name="distancia" value="${alojamiento.centerDistance}"><br>
    
                <label for="valoracion"><span>Valoración media</span></label><br>
                <input type="number" id="valoracion" name="valoracion" step="0.1" value="${alojamiento.gradesAverage}"><br>
    
                <label for="descripcion"><span>Descripción</span></label><br>
                <textarea id="descripcion" name="descripcion">${alojamiento.description}</textarea><br>

                <div id="servicios">
                    <span>Servicios e instalaciones:</span>

                    <div class="contenedor-checkbox">
                        <input type="checkbox" id="wifi" name="servicios" value="wifi">
                        <label for="wifi"><span>Wifi</span></label>
                    </div>
                    <div class="contenedor-checkbox">
                        <input type="checkbox" id="parking" name="servicios" value="parking">
                        <label for="parking"><span>Parking</span></label>
                    </div>
                    <div class="contenedor-checkbox">
                        <input type="checkbox" id="piscina" name="servicios" value="piscina">
                        <label for="piscina"><span>Piscina</span></label>
                    </div>
                </div>

                <div id="mascotas">
                    <span>¿Permite mascotas?</span>
                    <input type="radio" id="si" name="mascotas" value="si">
                    <label for="si"><span>SÍ</span></label>
                    <input type="radio" id="no" name="mascotas" value="no">
                    <label for="no"><span>NO</span></label>
                </div>

                <input type="submit" value="Confirmar cambios">
            </form>
        </div>

        <div id="contenedor-aux">
            <h2>Añadir nueva habitación</h2>
            <a href="ListAccommodationsServlet.do?idp=${alojamiento.id}">Ver las habitaciones de ${alojamiento.name}</a>

            <form id="añadir-habitacion" action="CreateAccommodationServlet.do" method="post">
                <label for="nombre"><span>Nombre</span></label><br>
                <input type="text" id="nombre" name="nombre"><br>

                <label for="descripcion-hab"><span>Descripción</span></label><br>
                <textarea id="descripcion-hab" name="descripcion-hab"></textarea><br>
    
                <label for="precio-hab"><span>Precio</span></label><br>
                <input type="number" id="precio-hab" name="precio-hab" step="1"><br>
                
                <label for="disponibles"><span>Nº habitaciones disponibles</span></label><br>
                <input type="number" id="disponibles" name="disponibles" step="1"><br>
                
                <input type="submit" value="Añadir habitación">
            </form>

        </div>

    </div>
 
</body>
</html>