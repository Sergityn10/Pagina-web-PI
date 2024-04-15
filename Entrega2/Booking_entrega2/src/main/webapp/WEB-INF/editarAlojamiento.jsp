<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Alojamiento</title>
    <link rel="stylesheet" href="css/editarAlojamiento.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
</head>
<body>
   <header>
		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>
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
                
                <input type="hidden" id="disponibilidad" name="disponibilidad" value="${alojamiento.available}">

                <input type="submit" value="Confirmar cambios">
            </form>
        </div>

        <div id="contenedor-aux">
            <h2>Añadir nueva habitación</h2>
            <a href="ListAccommodationsServlet.do?idp=${alojamiento.id}">Ver las habitaciones de ${alojamiento.name}</a>

            <form id="añadir-habitacion" action="CreateAccommodationServlet.do?idp=${alojamiento.id}" method="post">
                <label for="nombre"><span>Nombre</span></label><br>
                <input type="text" id="nombre" name="nombre" required><br>

                <label for="descripcion-hab"><span>Descripción</span></label><br>
                <textarea id="descripcion-hab" name="descripcion-hab"></textarea><br>
    
                <label for="precio-hab"><span>Precio</span></label><br>
                <input type="number" id="precio-hab" name="precio-hab" step="1" required><br>
                
                <label for="disponibles"><span>Nº habitaciones disponibles</span></label><br>
                <input type="number" id="disponibles" name="disponibles" step="1" required><br>
                
                <input type="submit" value="Añadir habitación">
            </form>

        </div>

    </div>
 
</body>
</html>