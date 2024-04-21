<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registro</title>
<link rel="icon" href="img/icono-booking.png" type="image/png">
<link rel="stylesheet" href="css/registro.css">
<link rel="stylesheet" href="css/header.css">
</head>
<body>
	<header>
		<c:import url="/WEB-INF/Componentes/header.jsp"/>
	</header>
	<div id="main">
		<div id="contenedor-central">
			<form id="formulario-registro" method="post" action="RegisterServlet.do">
				<h1>¡Únete a nosotros!</h1>

				<label for="nombre"><span>Nombre</span></label><br> <input
					type="text" name="nombre" placeholder="Ingresa tu nombre" required><br>

				<label for="apellidos"><span>Apellidos</span></label><br> <input
					type="text" name="apellidos" placeholder="Ingresa tus apellidos"
					required><br> <label for="email"><span>Correo
						electrónico</span></label><br> <input type="email" name="email"
					placeholder="Indica tu dirección de correo electrónico" required><br>

				<label for="password"><span>Contraseña</span></label><br> <input
					type="password" name="password"
					placeholder="Introduce tu contraseña" 
					pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" title="La contraseña debe tener al menos una letra mayúscula, una letra minúscula, un número y un carácter especial (@, $, !, %, *, ?, &), y debe tener una longitud mínima de 8 caracteres." required><br>

				<p>
					<input type="submit" value="Crear cuenta">
				</p>
			</form>


			<hr class="separator">

			<p id="crear-cuenta">
				¿Ya tienes cuenta? <a href="LogInServlet.do">Inicia sesión</a>
			</p>

			<hr class="separator">

			<p id="terminos">
				Al crear una cuenta, aceptas nuestros <a href="">Términos y <br>condiciones
				</a>. Por favor, lee nuestra <a href="">Política de privacidad</a>
			</p>


		</div>

	</div>



</body>