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
<link rel="stylesheet" href="css/header.css">
</head>
<body>
	<header>
		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>
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