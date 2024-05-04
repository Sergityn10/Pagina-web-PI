
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="es.unex.pi.model.Category" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>AÃ±adir Alojamiento</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/aÃ±adirAlojamiento.css">
    <link rel="stylesheet" href="css/header.css">
</head>
<body>
   <header>
		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>
    <div id="main">
        <div id="contenedor-central">
            <form id="formulario-registro" method="post" action="${pageContext.request.contextPath}/CreatePropertyServlet.do">
                <h1>AÃ±adir Alojamiento</h1>

                
                <label for="nombre"><span>Nombre del Alojamiento</span></label><br>
                <input type="text" id="nombre" name="nombre" required><br>
                
                <label for="localidad"><span>Localidad</span></label><br>
                <input type="text" id="localidad" name="localidad" required><br>
            

                <label for="direccion"><span>DirecciÃ³n</span></label><br>
                <input type="text" id="direccion" name="direccion" required><br>
            
                <label for="telefono"><span>TelÃ©fono</span></label><br>

                <input type="tel" id="telefono" name="telefono" required><br>
            
                <label for="distancia"><span>Distancia al centro (metros)</span></label><br>
                <input type="number" id="distancia" name="distancia" required><br>
            

                <label for="valoracion"><span>Valoración media</span></label><br>
                <input type="number" id="valoracion" name="valoracion" step="0.1" required><br>
            
                <label for="descripcion"><span>Descripción</span></label><br>

                <textarea id="descripcion" name="descripcion" required></textarea><br>
            
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
                    <input type="radio" id="si" name="mascotas" value="si" required>
                    <label for="si"><span>SÍ</span></label>

                    <input type="radio" id="no" name="mascotas" value="no" required>
                    <label for="no"><span>NO</span></label>
                </div>
            

                <input type="submit" value="Añadir Alojamiento">

            </form>
            
        </div>
    </div>


  
</body>