<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Inicio de Sesión</title>
<link rel="icon" href="img/icono-booking.png" type="image/png">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div id="header">
		<h1>Booking.com</h1>
		<div id="botones-header">
			<img src="img/Banderas/españa.png" alt="Icono España">
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
				<!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.-->
				<path
					d="M464 256A208 208 0 1 0 48 256a208 208 0 1 0 416 0zM0 256a256 256 0 1 1 512 0A256 256 0 1 1 0 256zm169.8-90.7c7.9-22.3 29.1-37.3 52.8-37.3h58.3c34.9 0 63.1 28.3 63.1 63.1c0 22.6-12.1 43.5-31.7 54.8L280 264.4c-.2 13-10.9 23.6-24 23.6c-13.3 0-24-10.7-24-24V250.5c0-8.6 4.6-16.5 12.1-20.8l44.3-25.4c4.7-2.7 7.6-7.7 7.6-13.1c0-8.4-6.8-15.1-15.1-15.1H222.6c-3.4 0-6.4 2.1-7.5 5.3l-.4 1.2c-4.4 12.5-18.2 19-30.6 14.6s-19-18.2-14.6-30.6l.4-1.2zM224 352a32 32 0 1 1 64 0 32 32 0 1 1 -64 0z" /></svg>
		</div>
	</div>
	<div id="main">
		<div id="contenedor-central">
			<form id="formulario-inicio" action="LogInServlet.do" method="post">
				<h1>Inicia sesión o crea una cuenta</h1>
				<c:if test="${not empty mensajeError}">
					<p id="error-inicio">${mensajeError}</p>
				</c:if>
				<label for="email"><span>E-mail</span></label><br> <input
					type="email" name="email"
					placeholder="Indica tu dirección de email" required><br>

				<label for="password"><span>Contraseña</span></label><br> <input
					type="password" name="password"
					placeholder="Introduce tu contraseña" required><br>

				<p>
					<input type="submit" value="Continuar con e-mail">
				</p>
			</form>

			<div id="opciones">
				<p>o usar una de estas opciones</p>
				<div class="logos">
					<div class="logo-wrapper">
						<img src="img/Logos/facebook.png" alt="Facebook">
					</div>
					<div class="logo-wrapper">
						<img src="img/Logos/google.png" alt="Google">
					</div>
					<div class="logo-wrapper">
						<img src="img/Logos/apple.png" alt="Apple">
					</div>
				</div>
			</div>

			<hr class="separator">

			<p id="crear-cuenta">
				¿Eres nuevo en Booking? <a href="RegisterServlet.do">Crear cuenta</a>
			</p>

			<hr class="separator">

			<p id="terminos">
				Al iniciar sesión o al crear una cuenta, aceptas nuestros <a href="">Términos
					y <br>condiciones
				</a> y la <a href="">Política de privacidad</a>
			</p>

			<hr class="separator">

			<p id="derechos">
				Todos los derechos reservados. <br> Copyright (2006 - 2024) -
				Booking.com
			</p>

		</div>

	</div>



</body>