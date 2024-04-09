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
        <h1>ACCOUNT SETTINGS</h1>
        <div class="contenedor-perfil">
            <section class="card-perfil">
                <h2>Profile Information</h2>
                <p>Update your information and find out how its used.</p>
                <a href="">Manage personal details</a>
            </section>
             <section class="card-perfil">
                <h2>Your favorites properties</h2>
                <p>Show all the properties saved in your favorites list.</p>
                <a href="${pageContext.request.contextPath}/favorites/ListFavoritesPropertiesByUsersServlet.do">Show your favorite properties</a>
            </section>
            
             <section class="card-perfil">
                <h2>My registered properties</h2>
                <p>Manage, update and show all the attributes about all your registered properties.</p>
                <a href="${pageContext.request.contextPath}/properties/ListPropertiesServlet.do">Manage registered properties</a>
            </section>
             <section class="card-perfil">
                <h2>My books</h2>
                <img src="/images/user.png" alt="Imagen usuario" />
                <p>Update your information and find out how its used.</p>
                <a href="">Manage personal details</a>
            </section>
             <section class="card-perfil">
                <h2>My reviews</h2>
                <p>Show all your reviews provided to properties.</p>
                <a href="${pageContext.request.contextPath}/reviews/ListReviewsServlet.do">Show my reviews</a>
            </section>
        </div>
        
    </main>
</body>
</html>