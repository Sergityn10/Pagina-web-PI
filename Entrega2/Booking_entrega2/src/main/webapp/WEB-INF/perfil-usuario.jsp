<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
    <link rel="icon" href="img/icono-booking.png" type="image/png">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style-perfil-usuario.css">
</head>
<body>
    
        <header>
        <c:import url="/WEB-INF/Componentes/header.jsp"/>

        </header>
    

    <main>
        <!-- Contenido principal -->
        <h1>CONFIGURACIÓN DE LA CUENTA</h1>
        <div class="contenedor-perfil">
            <section class="card-perfil">
                <h2>Información del perfil</h2>
                <p>Actualiza tus datos personales.</p>
                <a href="EditUserServlet.do">Editar perfil</a>
            </section>
             <section class="card-perfil">
                <h2>Tus alojamientos favoritos</h2>
                <p>Revisa todos tus alojamientos favoritos</p>
                <a href="${pageContext.request.contextPath}/favorites/ListFavoritesPropertiesByUsersServlet.do">Ver mis alojamientos favoritos</a>
            </section>
            
             <section class="card-perfil">
                <h2>Mis propiedades registradas</h2>
                <p>Gestiona, actualiza y revisa toda la información acerca de tus apartamentos favoritos</p>
                <a href="${pageContext.request.contextPath}/properties/ListPropertiesServlet.do">Gestionar mis alojamientos</a>
            </section>
             <section class="card-perfil">
                <h2>Mis reservas</h2>
                <img src="/images/user.png" alt="Imagen usuario" />
                <p>Recuerda y revisa tus reservas realizadas</p>
                <a href="">Ver mis reservas</a>
            </section>
             <section class="card-perfil">
                <h2>Mis reseñas</h2>
                <p>Mira todas tus reseñas en alojamientos</p>
                <a href="${pageContext.request.contextPath}/reviews/ListReviewsServlet.do">Ver mis reseñas</a>
            </section>
        </div>
        
    </main>
</body>
</html>