
<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Alojamientos</title>
    <link rel="icon" href="img/icono-booking.png" type="image/png">

    <link rel="stylesheet" href="css/listaAlojamientos.css">
</head>
<body>
    <header>
        <c:import url="/WEB-INF/Componentes/header.jsp"/>
            <nav id="enlaces-navegacion">
                <div class="navegacion-flights">
                    <a id="button-flights" href="">
                        <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path d="M2.75 12h18.5c.69 0 1.25.56 1.25 1.25V18l.75-.75H.75l.75.75v-4.75c0-.69.56-1.25 1.25-1.25zm0-1.5A2.75 2.75 0 0 0 0 13.25V18c0 .414.336.75.75.75h22.5A.75.75 0 0 0 24 18v-4.75a2.75 2.75 0 0 0-2.75-2.75H2.75zM0 18v3a.75.75 0 0 0 1.5 0v-3A.75.75 0 0 0 0 18zm22.5 0v3a.75.75 0 0 0 1.5 0v-3a.75.75 0 0 0-1.5 0zm-.75-6.75V4.5a2.25 2.25 0 0 0-2.25-2.25h-15A2.25 2.25 0 0 0 2.25 4.5v6.75a.75.75 0 0 0 1.5 0V4.5a.75.75 0 0 1 .75-.75h15a.75.75 0 0 1 .75.75v6.75a.75.75 0 0 0 1.5 0zm-13.25-3h7a.25.25 0 0 1 .25.25v2.75l.75-.75h-9l.75.75V8.5a.25.25 0 0 1 .25-.25zm0-1.5A1.75 1.75 0 0 0 6.75 8.5v2.75c0 .414.336.75.75.75h9a.75.75 0 0 0 .75-.75V8.5a1.75 1.75 0 0 0-1.75-1.75h-7z"></path>
                            </svg></span>
                        <span>Alojamientos</span>
                    </a>       
                </div>

                <div class="navegacion-flights">
                    <a id="button-flights" href="">
                        <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path d="M20.505 7.5l-15.266.022.672.415-1.1-2.2a.75.75 0 0 0-.638-.414l-2.293-.1C.82 5.228-.003 6.06.003 7.083c.002.243.051.484.146.709l2.072 4.68a2.947 2.947 0 0 0 2.701 1.778h4.043l-.676-1.075-2.484 5.168A1.831 1.831 0 0 0 7.449 21h2.099a1.85 1.85 0 0 0 1.419-.664l5.165-6.363-.582.277h4.956c1.82.09 3.399-1.341 3.49-3.198l.004-.134a3.426 3.426 0 0 0-3.44-3.419l-.074.001zm.02 1.5h.042a1.924 1.924 0 0 1 1.933 1.914l-.002.065a1.866 1.866 0 0 1-1.955 1.772l-4.993-.001a.75.75 0 0 0-.582.277l-5.16 6.355a.346.346 0 0 1-.26.118h-2.1a.336.336 0 0 1-.3-.49l2.493-5.185a.75.75 0 0 0-.676-1.075H4.924a1.45 1.45 0 0 1-1.328-.878l-2.07-4.676a.35.35 0 0 1 .326-.474l2.255.1-.638-.415 1.1 2.2a.75.75 0 0 0 .672.415L20.507 9zM16.323 7.76l-2.992-4.02A1.851 1.851 0 0 0 11.85 3H9.783a1.85 1.85 0 0 0-1.654 2.672l1.439 2.91a.75.75 0 0 0 1.344-.664L9.472 5.007a.351.351 0 0 1 .312-.507h2.066a.35.35 0 0 1 .279.14l2.99 4.017a.75.75 0 1 0 1.203-.896z"></path>
                            </svg></span>
                        <span>Vuelos</span>
                    </a>   
                </div>

                <div class="navegacion-flights">
                    <a id="button-flights" href="">
                        <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" data-rtl-flip="true">
                            <path d="M6.306 17.25a8.25 8.25 0 1 1 11.69-7.502.75.75 0 1 0 1.5 0A9.75 9.75 0 0 0 13.812.889C8.917-1.356 3.13.791.884 5.685-1.36 10.58.786 16.367 5.68 18.613a.75.75 0 0 0 .626-1.364zM3.756 3.5l5.28 2a.75.75 0 0 1 .475.851l-.313 1.57a.75.75 0 0 1-.554.58l-2.08.518a.75.75 0 0 0-.514.45l-1.154 2.884a2.242 2.242 0 0 1-.84 1.037l-1.84 1.263a.75.75 0 1 0 .85 1.236l1.83-1.257a3.731 3.731 0 0 0 1.393-1.722l1.153-2.884-.514.449 2.079-.52a2.25 2.25 0 0 0 1.661-1.74l.314-1.57a2.25 2.25 0 0 0-1.417-2.548l-5.277-2a.75.75 0 1 0-.532 1.403zm11.565-.57l-1.467 2.926a2.25 2.25 0 0 0-.122 1.718l.557 1.663a.75.75 0 1 0 1.422-.476L15.154 7.1a.75.75 0 0 1 .041-.572l1.466-2.924a.75.75 0 1 0-1.34-.672zm7.175 16.192v2.625a.75.75 0 0 1-.75.75h-10.5a.75.75 0 0 1-.75-.75v-5.25a.75.75 0 0 1 .75-.75h10.5a.75.75 0 0 1 .75.75v2.625zm1.5 0v-2.625a2.25 2.25 0 0 0-2.25-2.25h-10.5a2.25 2.25 0 0 0-2.25 2.25v5.25a2.25 2.25 0 0 0 2.25 2.25h10.5a2.25 2.25 0 0 0 2.25-2.25v-2.625zm-12-4.125v8.25a.75.75 0 0 0 1.5 0v-8.25a.75.75 0 0 0-1.5 0zm7.5 0v8.25a.75.75 0 0 0 1.5 0v-8.25a.75.75 0 0 0-1.5 0zm-4.5.002v-.75a1.5 1.5 0 0 1 3 0V15a.75.75 0 0 0 1.5 0v-.75a3 3 0 1 0-6 0V15a.75.75 0 0 0 1.5 0z"></path>
                            </svg></span>
                        <span>Vuelo + Hotel</span>
                    </a>   
                </div>

                <div class="navegacion-flights">
                    <a id="button-flights" href="">
                        <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path d="M21.684 9.443l-1.7-3.79c-.42-1.128-1.542-1.905-2.794-1.903H6.809a2.999 2.999 0 0 0-2.811 1.947L2.316 9.443a.75.75 0 1 0 1.368.614l1.7-3.79c.238-.63.798-1.018 1.424-1.017h10.383a1.5 1.5 0 0 1 1.407.973l1.718 3.834a.75.75 0 1 0 1.368-.614zM.75 16.468V18a2.25 2.25 0 0 0 4.5 0v-1.5a.75.75 0 0 0-1.5 0V18a.75.75 0 0 1-1.5 0v-1.532a.75.75 0 0 0-1.5 0zm21 0V18a.75.75 0 0 1-1.5 0v-1.5a.75.75 0 0 0-1.5 0V18a2.25 2.25 0 0 0 4.5 0v-1.532a.75.75 0 0 0-1.5 0zM19.875 13.5a.375.375 0 0 1-.375-.375.75.75 0 0 0 1.5 0c0-.621-.504-1.125-1.125-1.125a.75.75 0 0 0 0 1.5zm.375-.375a.375.375 0 0 1-.375.375.75.75 0 0 0 0-1.5c-.621 0-1.125.504-1.125 1.125a.75.75 0 0 0 1.5 0zm-.375-.375c.207 0 .375.168.375.375a.75.75 0 0 0-1.5 0c0 .621.504 1.125 1.125 1.125a.75.75 0 0 0 0-1.5zm-.375.375c0-.207.168-.375.375-.375a.75.75 0 0 0 0 1.5c.621 0 1.125-.504 1.125-1.125a.75.75 0 0 0-1.5 0zM4.125 12C3.504 12 3 12.504 3 13.125a.75.75 0 0 0 1.5 0 .375.375 0 0 1-.375.375.75.75 0 0 0 0-1.5zm1.125 1.125c0-.621-.504-1.125-1.125-1.125a.75.75 0 0 0 0 1.5.375.375 0 0 1-.375-.375.75.75 0 0 0 1.5 0zM4.125 14.25c.621 0 1.125-.504 1.125-1.125a.75.75 0 0 0-1.5 0c0-.207.168-.375.375-.375a.75.75 0 0 0 0 1.5zM3 13.125c0 .621.504 1.125 1.125 1.125a.75.75 0 0 0 0-1.5c.207 0 .375.168.375.375a.75.75 0 0 0-1.5 0zM2.75 10.5h18.5c.69 0 1.25.56 1.25 1.25v3.75a.25.25 0 0 1-.25.25H1.75a.25.25 0 0 1-.25-.25v-3.75c0-.69.56-1.25 1.25-1.25zm0-1.5A2.75 2.75 0 0 0 0 11.75v3.75c0 .966.784 1.75 1.75 1.75h20.5A1.75 1.75 0 0 0 24 15.5v-3.75A2.75 2.75 0 0 0 21.25 9H2.75z"></path>
                            </svg></span>
                        <span>Alquiler de coches</span>
                    </a>   
                </div>

                <div class="navegacion-flights">
                    <a id="button-flights" href="">
                        <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path d="M13.5 3a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zM15 3a3 3 0 1 0-6 0 3 3 0 0 0 6 0zm6 4.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm1.5 0a3 3 0 1 0-6 0 3 3 0 0 0 6 0zM6 7.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm1.5 0a3 3 0 1 0-6 0 3 3 0 0 0 6 0zM21 15a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm1.5 0a3 3 0 1 0-6 0 3 3 0 0 0 6 0zm-9-3.75a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm1.5 0a3 3 0 1 0-6 0 3 3 0 0 0 6 0zM6 15a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm1.5 0a3 3 0 1 0-6 0 3 3 0 0 0 6 0zm10.066 1.277a7.5 7.5 0 0 1-3.077 2.05.75.75 0 0 0 .498 1.415 9 9 0 0 0 3.693-2.46.75.75 0 1 0-1.114-1.005zm1.798-6.466c.177.922.183 1.869.015 2.792a.75.75 0 1 0 1.476.268c.2-1.106.194-2.24-.019-3.344a.75.75 0 1 0-1.472.284zm-5.337-5.784a7.5 7.5 0 0 1 3.54 2.196.75.75 0 0 0 1.113-1.004 9.002 9.002 0 0 0-4.247-2.636.75.75 0 1 0-.406 1.444zM6.434 6.223a7.5 7.5 0 0 1 3.539-2.196.75.75 0 1 0-.406-1.444A9.001 9.001 0 0 0 5.32 5.219a.75.75 0 0 0 1.114 1.004zM4.636 12.69a7.602 7.602 0 0 1 0-2.878.75.75 0 1 0-1.472-.284 9.102 9.102 0 0 0 0 3.446.75.75 0 0 0 1.472-.284zm4.876 5.639a7.517 7.517 0 0 1-3.035-2.005.75.75 0 0 0-1.106 1.014 9.017 9.017 0 0 0 3.641 2.405.75.75 0 1 0 .5-1.414zM7.31 21.872A1.5 1.5 0 0 0 8.672 24h6.656a1.5 1.5 0 0 0 1.362-2.128l-3.314-8.217c-.361-.785-1.252-1.114-2.005-.767a1.5 1.5 0 0 0-.733.734l-3.343 8.283zm1.377.595l3.328-8.25-.015.033 3.313 8.217.015.033H8.672z"></path>
                            </svg></span>
                        <span>Atracciones turísticas</span>
                    </a>   
                </div>

                <div class="navegacion-flights">
                    <a id="button-flights" href="">
                        <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path d="M21.75 15.5V8a.75.75 0 0 0-1.5 0v7.5a.75.75 0 0 0 1.5 0zm-16.5 0V8a.75.75 0 0 0-1.5 0v7.5a.75.75 0 0 0 1.5 0zM3 8.75h3a.75.75 0 0 0 0-1.5H3a.75.75 0 0 0 0 1.5zm6.75 6.75v-6a.75.75 0 0 1 1.5 0v6a.75.75 0 0 0 1.5 0v-6a2.25 2.25 0 0 0-4.5 0v6a.75.75 0 0 0 1.5 0zM9 13.25h3a.75.75 0 0 0 0-1.5H9a.75.75 0 0 0 0 1.5zm5.304-4.971l3 7.5a.75.75 0 0 0 1.392-.557l-3-7.5a.75.75 0 0 0-1.392.557zm3-.558l-3 7.5a.75.75 0 0 0 1.392.557l3-7.5a.75.75 0 0 0-1.392-.557zM.75 5h22.5a.75.75 0 0 0 0-1.5H.75a.75.75 0 0 0 0 1.5zm0 15h22.5a.75.75 0 0 0 0-1.5H.75a.75.75 0 0 0 0 1.5z"></path>
                            </svg></span>
                        <span>Taxis aeropuerto</span>
                    </a>   
                </div>
            </nav>
            
        
        <form method="get" action="SearchServlet.do">
        <div class="container-estancias">
        <div class="buscador">
                
                    <div class="item-busqueda">
                			<span>
                			<svg>
                            <path d="M2.75 12h18.5c.69 0 1.25.56 1.25 1.25V18l.75-.75H.75l.75.75v-4.75c0-.69.56-1.25 1.25-1.25zm0-1.5A2.75 2.75 0 0 0 0 13.25V18c0 .414.336.75.75.75h22.5A.75.75 0 0 0 24 18v-4.75a2.75 2.75 0 0 0-2.75-2.75H2.75zM0 18v3a.75.75 0 0 0 1.5 0v-3A.75.75 0 0 0 0 18zm22.5 0v3a.75.75 0 0 0 1.5 0v-3a.75.75 0 0 0-1.5 0zm-.75-6.75V4.5a2.25 2.25 0 0 0-2.25-2.25h-15A2.25 2.25 0 0 0 2.25 4.5v6.75a.75.75 0 0 0 1.5 0V4.5a.75.75 0 0 1 .75-.75h15a.75.75 0 0 1 .75.75v6.75a.75.75 0 0 0 1.5 0zm-13.25-3h7a.25.25 0 0 1 .25.25v2.75l.75-.75h-9l.75.75V8.5a.25.25 0 0 1 .25-.25zm0-1.5A1.75 1.75 0 0 0 6.75 8.5v2.75c0 .414.336.75.75.75h9a.75.75 0 0 0 .75-.75V8.5a1.75 1.75 0 0 0-1.75-1.75h-7z"></path>
                            </svg></span>
                        <input type="text" name="lugar-alojamiento"  placeholder="¿Adónde vas?" value="${ciudad}" required>
                    </div>
                    <div class="item-busqueda">
                        <input type="date" name="check-in" id="" placeholder="check-in">
                    
                        <input type="date" name="check-out" id="" placeholder="Check-out">
                    </div>
                    <div class="item-busqueda">
                        <span id="icono-persona"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                            <path d="M16.5 6a4.5 4.5 0 1 1-9 0 4.5 4.5 0 0 1 9 0zM18 6A6 6 0 1 0 6 6a6 6 0 0 0 12 0zM3 23.25a9 9 0 1 1 18 0 .75.75 0 0 0 1.5 0c0-5.799-4.701-10.5-10.5-10.5S1.5 17.451 1.5 23.25a.75.75 0 0 0 1.5 0z"></path>
                            </svg></span>
                        <input type="number" name="adultos" id="" placeholder="Adultos" min="1">
                        <input type="number" name="menores" id="" placeholder="Menores" >
                        <input type="number" name="habitaciones" id="" placeholder="Habitaciones">
                    </div>
                    <div class="item-boton-buscar">
                        <button class="boton-buscar" type="submit">Buscar</button>
                    </div>
                    
                    
                    
                    
	                        
	                    
               
                
    
                
            </div>
            <section class="filtros">
           		<input type="radio" id="todos" value="todos" name="disponibilidad" <c:if test="${disp == 'todos'}">checked</c:if> required>
                <label for="disp_todos">Todos</label>
           
            
                <input type="radio" id="con_disp" value="con_disp" name="disponibilidad" <c:if test="${disp == 'con_disp'}">checked</c:if> required>
                <label for="hoteles">Disponibles</label>
            
           
                <input type="radio" id="no_disp" value="no_disp" name="disponibilidad" <c:if test="${disp == 'no_disp'}">checked</c:if> required>
                <label for="no_disp">Sin disponibilidad</label>
                
                <input type="checkbox" id="asc_valoracion" value="asc_valoracion" name="valoracion" <c:if test="${valoracion == 'asc_valoracion'}">checked</c:if>>
                <label for="no_disp">Ordenar por valoración</label>
             </section>
            
        </div>
             </form>
    </header>

    <div id="main">
        <div id="main-izquierda">
            <div id="ubicacion">
                <p>${ciudad }<a href=""><strong>: cambiar dirección</strong></a>
                </p>
            </div>

            <div id="categorias-lateral">
            
                <div id="categorias-lateral-encabezado">
                    <h2>Filtrar por:</h2>
                    <button type="submit" id="reiniciar" class="boton-reiniciar">Filtrar</button>
                </div>
                
                
                <ul class="checkbox-list">
                    <h3>Filtros populares</h3>
                    <li class="checkbox-item">
                        <input type="checkbox" id="cancelacion_gratuita" name="cancelacion_gratuita">
                        <label for="cancelacion_gratuita">Cancelación gratuita</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="hoteles" name="hoteles">
                        <label for="hoteles">Hoteles</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="desayuno_incluido" name="desayuno_incluido">
                        <label for="desayuno_incluido">Desayuno incluido</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="superoferta" name="superoferta">
                        <label for="superoferta">Superoferta</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="menos_de_1km" name="menos_de_1km">
                        <label for="menos_de_1km">Menos de 1km</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="4_estrellas" name="4_estrellas">
                        <label for="4_estrellas">4 estrellas</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="mascotas_incluidas" name="mascotas_incluidas">
                        <label for="mascotas_incluidas">Mascotas incluidas</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="parking" name="parking">
                        <label for="parking">Parking</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="wifi_gratis" name="wifi_gratis">
                        <label for="wifi_gratis">Wifi gratis</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="bano_privado" name="bano_privado">
                        <label for="bano_privado">Baño privado</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="cocina" name="cocina">
                        <label for="cocina">Cocina</label>
                    </li>
                </ul>

                <ul class="checkbox-list">
                    <h3>Categoría del alojamiento</h3>
                    <li class="checkbox-item">
                        <input type="checkbox" id="estrella1" name="estrella1">
                        <label for="estrella1">1 estrella</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="estrella2" name="estrella2">
                        <label for="estrella2">2 estrellas</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="estrella3" name="estrella3">
                        <label for="estrella3">3 estrellas</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="estrella4" name="estrella4">
                        <label for="estrella4">4 estrellas</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="estrella5" name="estrella5">
                        <label for="estrella5">5 estrellas</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="otros" name="otros">
                        <label for="otros">Otros</label>
                    </li>
                </ul>

                <ul class="checkbox-list">
                    <h3>Barrio</h3>
                    <li class="checkbox-item">
                        <input type="checkbox" id="zonafav" name="zonafav">
                        <label for="zonafav">Zona favorita de los clientes</label>
                    </li>
                </ul>

                <ul class="checkbox-list">
                    <h3>Distancia desde el centro</h3>
                    <li class="checkbox-item">
                        <input type="checkbox" id="km1" name="km1">
                        <label for="km1">Menos de 1 km</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="km3" name="km3">
                        <label for="km3">Menos de 3 kms</label>
                    </li>
                    <li class="checkbox-item">
                        <input type="checkbox" id="km5" name="km5">
                        <label for="km5">Menos de 5 kms</label>
                    </li>
                </ul>

            

            </div>
        </div>

        <div id="main-derecha">
        
            <ul id="lista-localizaciones">
            
            <c:forEach var="alojamiento" items="${listaAlojamientos}">
            	<li class="elem-loc">
                        <img src="img/Alojamientos/hotelCarlos.webp" alt="${alojamiento.name }">
                        <a href="favorites/addFavoritePropertyUserServlet.do?idp=${alojamiento.id }">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M225.8 468.2l-2.5-2.3L48.1 303.2C17.4 274.7 0 234.7 0 192.8v-3.3c0-70.4 50-130.8 119.2-144C158.6 37.9 198.9 47 231 69.6c9 6.4 17.4 13.8 25 22.3c4.2-4.8 8.7-9.2 13.5-13.3c3.7-3.2 7.5-6.2 11.5-9c0 0 0 0 0 0C313.1 47 353.4 37.9 392.8 45.4C462 58.6 512 119.1 512 189.5v3.3c0 41.9-17.4 81.9-48.1 110.4L288.7 465.9l-2.5 2.3c-8.2 7.6-19 11.9-30.2 11.9s-22-4.2-30.2-11.9zM239.1 145c-.4-.3-.7-.7-1-1.1l-17.8-20c0 0-.1-.1-.1-.1c0 0 0 0 0 0c-23.1-25.9-58-37.7-92-31.2C81.6 101.5 48 142.1 48 189.5v3.3c0 28.5 11.9 55.8 32.8 75.2L256 430.7 431.2 268c20.9-19.4 32.8-46.7 32.8-75.2v-3.3c0-47.3-33.6-88-80.1-96.9c-34-6.5-69 5.4-92 31.2c0 0 0 0-.1 .1s0 0-.1 .1l-17.8 20c-.3 .4-.7 .7-1 1.1c-4.5 4.5-10.6 7-16.9 7s-12.4-2.5-16.9-7z"/></svg>
                           </a>
                        <div id="info-loc">
                            <div id="titulo-localizacion">
                                <a                             
                                <c:choose>
                            	<c:when test="${user == null}">
                            		href=""
                            	</c:when>
                            	<c:otherwise>
                            		href="chooseAlojamientoServlet.do?id=${alojamiento.id}"
                            	</c:otherwise>
                            	</c:choose>>
                            	<h2>${alojamiento.name}</h2></a>
                                <span id="valoracion">${alojamiento.gradesAverage}</span>
                            </div>
                            <c:if test="${user != null}">
                            	
                            </c:if>

                            <div id="estrellas">
                            	
                                <img id="icono-estrella" src="img/Iconos/estrella.svg" alt="estrella">
                                <img id="icono-estrella" src="img/Iconos/estrella.svg" alt="estrella">
                                <img id="icono-estrella" src="img/Iconos/estrella.svg" alt="estrella">
                                <img id="icono-estrella" src="img/Iconos/estrella.svg" alt="estrella">
                            </div>
                            <div id="segunda-linea-info">
                                <div id="segunda-izq">
                                    <a href=""><span>Ver en el mapa</span></a>
                                    
                                    <span>${alojamiento.centerDistance} km del centro</span>
                                </div>
                                <div id="segunda-dcha">
                                
                                    <span>Localización 9,5</span>
                                </div>     
                            </div>
                            <div id="info-loc-inferior">
                                <ul id="lista-alojamientos">
                                    <p>Descripción: ${alojamiento.description}</p>
                                </ul>

                                <div id="inferior-dcha">
                                    <span>€ 91</span>
                                    <p>Incluye tasas y cambios</p>
                                </div>

                            </div>

                            

                        </div>
                </li>
            </c:forEach>
            </ul>

			
        </div>
        
    
</body>
