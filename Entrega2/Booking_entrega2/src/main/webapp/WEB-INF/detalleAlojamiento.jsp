<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalles de Alojamiento</title>
    <link rel="icon" href="img/Logos/icono-booking.png" type="image/png">
    <link rel="stylesheet" href="css/detalleAlojamiento.css">
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



                 
    </header>
    <div id="main">
        <div id="enlace-secciones">
            <a href=""><span>Vista general</span></a>
            <a href=""><span>Info y precios</span></a>
            <a href=""><span>Servicios</span></a>
            <a href=""><span>Léeme</span></a>
            <a href=""><span>A tener en cuenta</span></a>
            <a href=""><span>Comentarios de clientes</span></a>
        </div>

        <hr class="separator">

        <div id="main-superior">
            <div id="superior-izq">
                <div class="recuadro">
                    <h2>Buscar</h2>
                    <form>
                        <div class="form-group">
                            <label for="name">Destino/Nombre del alojamiento:</label>
                            <input type="text" id="name" name="name" value="Cáceres">
                        </div>
                        <div class="form-group">
                            <label for="llegada">Fecha de entrada</label>
                            <input type="date" id="llegada" name="llegada" placeholder="Fecha llegada">
                        </div>
                        <div class="form-group">
                            <label for="salida">Fecha de salida</label>
                            <input type="date" id="salida" name="salida" placeholder="Fecha salida">
                        </div>
                        <div class="form-group">
                            <label for="adultos">Número de adultos:</label>
                            <input type="number" id="adultos" name="adultos" placeholder="Adultos">
                        </div>
                        <div class="form-group">
                            <label for="menores">Número de menores:</label>
                            <input type="number" id="menores" name="menores" placeholder="Menores">
                        </div>
                        <div class="form-group">
                            <label for="habitaciones">Número de habitaciones:</label>
                            <input type="number" id="habitaciones" name="habitaciones" placeholder="Habitaciones">
                        </div>
                        <div class="form-group-check">
                            <input type="checkbox" id="casas-apartamentos" name="casas-apartamentos">
                            <label for="casas-apartamentos">Casas y apartamentos enteros</label>
                        </div>
                        <div class="form-group-check">
                            <input type="checkbox" id="viajo-trabajo" name="viajo-trabajo">
                            <label for="viajo-trabajo">Viajo por trabajo</label>
                        </div>
                        <div class="form-group-check">
                            <input type="checkbox" id="necesito-parking" name="necesito-parking">
                            <label for="necesito-parking">Necesito parking</label>
                        </div>
                        <button type="submit"><span>Buscar</span></button>
                    </form>
                </div>

            </div>
            <div id="superior-dcha">
                <div id="nombre-alojamiento">
                
                    <h1>${prop.name}</h1>
                    
                    <button id="reservar-boton"><span>Reservar ahora</span></button>
                </div>
                <div id="info-superior">
                        <span id="direccion">Donoso Cortés 13-15, 10003 Cáceres, España - <a href="">Ubicación Excelente - Ver Mapa</a></span>
                        <span id="valoracion">8,6</span>

                </div>
                <div id="grid-fotos">
                    <img src="img/Alojamientos/hotel1.jpg" alt="Foto hotel">
                    <img src="img/Alojamientos/hotel2.jpg" alt="Foto hotel">
                    <img src="img/Alojamientos/hotel3.jpg" alt="Foto hotel">
                    <div id="carrusel-fotos">
                        <img src="img/Alojamientos/hotel4.jpg" alt="Foto hotel">
                        <img src="img/Alojamientos/hotel5.jpg" alt="Foto hotel">
                        <img src="img/Alojamientos/hotel6.jpg" alt="Foto hotel">
                        <img src="img/Alojamientos/hotel7.jpg" alt="Foto hotel">
                        <img src="img/Alojamientos/hotel8.jpg" alt="Foto hotel">
                        <img src="img/Alojamientos/hotel8.jpg" alt="Foto hotel">
                    </div>


                </div>

            </div>
        </div>

        <div id="main-inferior">
            <div id="parrafos-info">
                <p>¡Puedes conseguir un descuento Genius en Hotel Don Carlos Cáceres! Para ahorrar en este alojamiento, solo tienes que <a href="login.html">iniciar sesión.</a></p>
                <p> El Hotel Don Carlos ocupa un edificio de 1803 y está situado en el centro de Cáceres. El establecimiento ofrece habitaciones cómodas con muebles de estilo antiguo y WiFi gratuita. La catedral de Cáceres está a solo 400 metros.</p>
                <p>Las habitaciones del Hotel Don Carlos Cáceres disponen de aire acondicionado, baño privado moderno y suelo de baldosa. Algunas tienen paredes de piedra, y todas están equipadas con TV y calefacción.</p>
                <p>El Hotel Don Carlos Cáceres cuenta con consigna de equipaje, sala de desayunos y salón en recepción.</p>
                <p>La plaza Mayor de la ciudad queda a unos 300 metros, y los huéspedes disponen de aparcamiento privado.</p>
            </div>
            <div id="mas-informacion">
                <h3>Puntos fuertes del alojamiento</h3>
                <p>Situado en la zona mejor valorada de Cáceres, este hotel tiene una excelente puntuación en ubicación (9,6).</p>
                <h4>Más servicios ofrecidos</h4>
                <div class="elem-info">
                    <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                        <path d="M22.5 12c0 5.799-4.701 10.5-10.5 10.5S1.5 17.799 1.5 12 6.201 1.5 12 1.5 22.5 6.201 22.5 12zm1.5 0c0-6.627-5.373-12-12-12S0 5.373 0 12s5.373 12 12 12 12-5.373 12-12zm-9.75-1.5a1.5 1.5 0 0 1-1.5 1.5H10.5l.75.75v-4.5L10.5 9h2.25a1.5 1.5 0 0 1 1.5 1.5zm1.5 0a3 3 0 0 0-3-3H10.5a.75.75 0 0 0-.75.75v4.5c0 .414.336.75.75.75h2.25a3 3 0 0 0 3-3zm-4.5 6.75v-4.5a.75.75 0 0 0-1.5 0v4.5a.75.75 0 0 0 1.5 0z"></path>
                        </svg></span>
                    <span>Parking propio</span>
                </div>
                <div class="elem-info">
                    <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                        <path d="M14.25 18.75a2.25 2.25 0 1 1-4.5 0 2.25 2.25 0 0 1 4.5 0zm1.5 0a3.75 3.75 0 1 0-7.5 0 3.75 3.75 0 0 0 7.5 0zm2.08-5.833a8.25 8.25 0 0 0-11.666 0 .75.75 0 0 0 1.06 1.06 6.75 6.75 0 0 1 9.546 0 .75.75 0 0 0 1.06-1.06zm3.185-3.182c-4.979-4.98-13.051-4.98-18.03 0a.75.75 0 1 0 1.06 1.06c4.394-4.393 11.516-4.393 15.91 0a.75.75 0 1 0 1.06-1.06zm2.746-3.603C17.136-.043 6.864-.043.24 6.132A.75.75 0 1 0 1.26 7.23c6.05-5.638 15.429-5.638 21.478 0a.75.75 0 0 0 1.022-1.098z"></path>
                        </svg></span>
                    <span>WiFi gratis</span>
                </div>
                <div class="elem-info">
                    <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                        <path d="M6 .75v6a.75.75 0 0 0 1.5 0v-6a.75.75 0 0 0-1.5 0zm4.28 2.47l-3-3a.75.75 0 0 0-1.06 0l-3 3a.75.75 0 0 0 1.06 1.06l3-3H6.22l3 3a.75.75 0 1 0 1.06-1.06zM18 6.75v-6a.75.75 0 0 0-1.5 0v6a.75.75 0 0 0 1.5 0zm1.72-3.53l-3 3h1.06l-3-3a.75.75 0 1 0-1.06 1.06l3 3a.75.75 0 0 0 1.06 0l3-3a.75.75 0 0 0-1.06-1.06zM22.5 16.5v5.25a.75.75 0 0 1-.75.75H2.25a.75.75 0 0 1-.75-.75v-10.5a.75.75 0 0 1 .75-.75h19.5a.75.75 0 0 1 .75.75v5.25zm1.5 0v-5.25A2.25 2.25 0 0 0 21.75 9H2.25A2.25 2.25 0 0 0 0 11.25v10.5A2.25 2.25 0 0 0 2.25 24h19.5A2.25 2.25 0 0 0 24 21.75V16.5zM9 15a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm1.5 0a3 3 0 1 0-6 0 3 3 0 0 0 6 0zm1.5 7.5a4.5 4.5 0 1 0-9 0v.75c0 .414.336.75.75.75h7.5a.75.75 0 0 0 .75-.75v-.75zm-1.5 0v.75l.75-.75h-7.5l.75.75v-.75a3 3 0 1 1 6 0zM18 15a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm1.5 0a3 3 0 1 0-6 0 3 3 0 0 0 6 0zm1.5 7.5a4.5 4.5 0 1 0-9 0v.75c0 .414.336.75.75.75h7.5a.75.75 0 0 0 .75-.75v-.75zm-1.5 0v.75l.75-.75h-7.5l.75.75v-.75a3 3 0 1 1 6 0z"></path>
                        </svg></span>
                    <span>Ascensor</span>
                </div>
                <div class="elem-info">
                    <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                        <path d="M3.75 4.5h12a.75.75 0 0 1 .75.75v7.5a6.75 6.75 0 0 1-13.5 0v-7.5a.75.75 0 0 1 .75-.75zm0-1.5A2.25 2.25 0 0 0 1.5 5.25v7.5a8.25 8.25 0 0 0 16.5 0v-7.5A2.25 2.25 0 0 0 15.75 3h-12zm-3 18h22.5a.75.75 0 0 0 0-1.5H.75a.75.75 0 0 0 0 1.5zm16.5-15h1.5a3.763 3.763 0 0 1 3.75 3.752 3.762 3.762 0 0 1-3.752 3.748H17.1a.75.75 0 0 0 0 1.5h1.65A5.263 5.263 0 0 0 24 9.752 5.264 5.264 0 0 0 18.752 4.5H17.25a.75.75 0 0 0 0 1.5z"></path>
                        </svg></span>
                    <span>Desayuno incluido</span>
                </div>

                
                
                
            </div>

        </div>



        <hr class="separator">

        <div id="seccion-tabla">
            <div id="titulo-seccion-tabla">
                <h2>Disponibilidad</h2>
                <a href="">Igualamos el precio</a>
            </div>
            <table class="hotel-table">
                <thead>
                    <tr>
                        <th>Tipo de habitación</th>
                        <th>Número de personas</th>
                        <th>Descripción</th>
                        <th>Precio</th>
                        <th>Reservar</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="nombre-hab">Individual</td>
                        <td><span><svg viewBox="0 0 128 128" width="1em" height="1em">
                            <path d="M104 120H24a8 8 0 0 1-8-8V93.5a4 4 0 0 1 1-2.7C21.3 86.4 36.9 72 64 72s42.8 14.4 47 18.8a4 4 0 0 1 1 2.7V112a8 8 0 0 1-8 8zM64 8a28 28 0 1 0 28 28A28 28 0 0 0 64 8z"></path>
                            </svg></span></td>
                        <td>Habitación con 1 única cama individual</td>
                        <td>150 €</td>
                        <td><button class="boton-hab">Reservar</button></td>
                    </tr>
                    <tr>
                        <td class="nombre-hab">Doble</td>
                        <td><span><svg viewBox="0 0 128 128" width="1em" height="1em">
                            <path d="M104 120H24a8 8 0 0 1-8-8V93.5a4 4 0 0 1 1-2.7C21.3 86.4 36.9 72 64 72s42.8 14.4 47 18.8a4 4 0 0 1 1 2.7V112a8 8 0 0 1-8 8zM64 8a28 28 0 1 0 28 28A28 28 0 0 0 64 8z"></path>
                            </svg></span>
                            <span><svg viewBox="0 0 128 128" width="1em" height="1em">
                                <path d="M104 120H24a8 8 0 0 1-8-8V93.5a4 4 0 0 1 1-2.7C21.3 86.4 36.9 72 64 72s42.8 14.4 47 18.8a4 4 0 0 1 1 2.7V112a8 8 0 0 1-8 8zM64 8a28 28 0 1 0 28 28A28 28 0 0 0 64 8z"></path>
                                </svg></span></td>
                        <td>Habitación con 1 cama doble o 2 camas individuales</td>
                        <td>250 €</td>
                        <td><button class="boton-hab">Reservar</button></td>
                    </tr>
                    <tr>
                        <td class="nombre-hab">Familiar</td>
                        <td><span><svg viewBox="0 0 128 128" width="1em" height="1em">
                            <path d="M104 120H24a8 8 0 0 1-8-8V93.5a4 4 0 0 1 1-2.7C21.3 86.4 36.9 72 64 72s42.8 14.4 47 18.8a4 4 0 0 1 1 2.7V112a8 8 0 0 1-8 8zM64 8a28 28 0 1 0 28 28A28 28 0 0 0 64 8z"></path>
                            </svg></span>
                            <span><svg viewBox="0 0 128 128" width="1em" height="1em">
                                <path d="M104 120H24a8 8 0 0 1-8-8V93.5a4 4 0 0 1 1-2.7C21.3 86.4 36.9 72 64 72s42.8 14.4 47 18.8a4 4 0 0 1 1 2.7V112a8 8 0 0 1-8 8zM64 8a28 28 0 1 0 28 28A28 28 0 0 0 64 8z"></path>
                                </svg></span>
                            + <span><svg viewBox="0 0 128 128" width="1em" height="1em">
                                <path d="M104 120H24a8 8 0 0 1-8-8V93.5a4 4 0 0 1 1-2.7C21.3 86.4 36.9 72 64 72s42.8 14.4 47 18.8a4 4 0 0 1 1 2.7V112a8 8 0 0 1-8 8zM64 8a28 28 0 1 0 28 28A28 28 0 0 0 64 8z"></path>
                                </svg></span></td>
                        <td>Habitación con 1 cama doble + 1 cama individual</td>
                        <td>400 €</td>
                        <td><button class="boton-hab">Reservar</button></td>
                    </tr>
                </tbody>
            </table>
        </div>

       
        
		<section>
            <h2>VALORACIONES REALIZADAS POR LOS USUARIOS</h2>
            
            <div class="container-valoracion">
	            <c:forEach var="review" items="${reviewUser}" >
		            <article class="valoracion">
		                    <div class="user-grado">
		                        <h4>${review.value.name}</h4>
		                        
		                        <p>Valoración: ${review.key.grade}</p>
		                    </div>
		                    
		                    <q>${review.key.review}</q>
		                </article>
	            </c:forEach>
	                
			

            </div>
            
        </section>
        <c:if test="${user != null }"></c:if>
	        <c:choose>
		         <c:when test="${!conReview} ">
		         	<section id=container-create-review>
			            <h2>Agregar una review:</h2>
			            <form action="<c:url value="reviews/CreateReviewServlet.do?idp=${prop.id}"/>" method="post" id="reviewForm">
							<div>
								<input name="num_valoracion" type="range" min="1" max="5" oninput="valor_rango.value=parseInt(num_valoracion.value)" value="3"/>
				                <output for="num-valoracion" name="valor_rango"></output>
							</div>
			                
			                <textarea name="descripcion" id="descripcion" cols="30" rows="10" placeholder="Añade tu valoracion que creas convenientes sobre el alojamiento" required></textarea>
			                <button type="submit" class="boton-bg-azul">Enviar Review</button> 
			            </form>
			        </section>
		        </c:when>
		        
		        <c:otherwise>
		        	<section id=container-create-review>
			            <h2>Editar una review:</h2>
			            <form action="<c:url value="reviews/EditReviewServlet.do?idp=${prop.id}"/>" method="post" id="reviewForm">
							<div>
								<input name="num_valoracion" type="range" min="1" max="5" oninput="valor_rango.value=parseInt(num_valoracion.value)" value="${ownReview.grade }"/>
				                <output for="num-valoracion" name="valor_rango"></output>
							</div>
			                
			                <textarea name="descripcion" id="descripcion" cols="30" rows="10" placeholder="Añade tu valoracion que creas convenientes sobre el alojamiento" required>${ownReview.review}</textarea>
			                <button type="submit" class="boton-bg-azul">Editar Review</button> 
			            </form>
			        </section>
		        </c:otherwise>
	        </c:choose>
        
        
       
        
        
		
    </div>

</body>