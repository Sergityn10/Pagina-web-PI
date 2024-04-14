<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
	 <div class="container">
        <section class="container-trending-destination">
            <h3>Trending Destinations</h3>
            <p>Descubre los lugares más demandados y visitados de PAÍS</p>
            <div class="cards-container-destinations">
                
                <div class="row1-cards-destinations">
                    <div class="card-destino">
                        <a id="img1" href="">
                            <img src="img/caceres.jpg" alt="imagen-lugar">
                        </a>
                    <section  class="info-card-destinos">
                        <h2>Cáceres (Extremadura)</h2>
                        <img class="bandera" src="img/spain.png" alt="bandera-pais">
                    </section>
                        
                    </div>

                    <div class="card-destino">
                        <a id="img2" href="">
                            <img src="img/caceres.jpg" alt="imagen-lugar">
                        </a>
                        <section  class="info-card-destinos">
                            <h2>Cáceres (Extremadura)</h2>
                            <img class="bandera" src="img/spain.png" alt="bandera-pais">
                        </section>
                    </div>
                    
                
                
                </div>    
                <div class="row2-cards-destinations">
                        <div class="card-destino">
                            <a id="img3" href="">
                                <img src="img/sevilla.jpg" alt="imagen-lugar">
                            </a>
                            <section  class="info-card-destinos">
                                <h2>Sevilla (Andalucia)</h2>
                                <img class="bandera" src="img/spain.png" alt="bandera-pais">
                            </section>
                        </div>
                        
                        <div class="card-destino">
                            <a id="img4" href="">
                                <img src="img/barcelona.jpg" alt="imagen-lugar">
                            </a>
                            <section  class="info-card-destinos">
                                <h2>Barcelona (Cataluña)</h2>
                                <img class="bandera" src="img/spain.png" alt="bandera-pais">
                            </section>
                        </div>
                        
                        <div class="card-destino">
                            <a id="img5" href="">
                                <img src="img/madrid.jpg" alt="imagen-lugar">
                            </a>
                            <section  class="info-card-destinos">
                                <h2>Madrid (Madrid)</h2>
                                <img class="bandera" src="img/spain.png" alt="bandera-pais">
                            </section>
                        </div>
                        
                </div>        
                
                
                
            </div>
        </section>
    
        
            <h3>Descrubre PAÍS</h3>
            <div class="carrusel-fotos">
                <button class="boton-carrusel" id="anterior" onclick="cambiarFoto(-1)">❮</button>
                <div class="container-fotos">
                    
                            <div class="card-foto">
                                <a href="">
                                    <img src="img/barcelona.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>
                        
                            <div class="card-foto">
                                <a href="">
                                    <img src="img/caceres.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>
                        
                            <div class="card-foto">
                                <a href="">
                                    <img src="img/madrid.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>
                        
                            <div class="card-foto">
                                <a href="">
                                    <img src="img/madrid.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>
                       
                            <div class="card-foto">
                                <a href="">
                                    <img src="img/madrid.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>
                        
                            <div class="card-foto">
                                <a href="">
                                    <img src="img/madrid.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>
                        
                            <div class="card-foto">
                                <a href="">
                                    <img src="img/madrid.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>

                            <div class="card-foto">
                                <a href="">
                                    <img src="img/madrid.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>

                            <div class="card-foto">
                                <a href="">
                                    <img src="img/madrid.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>

                            <div class="card-foto">
                                <a href="">
                                    <img src="img/madrid.jpg" alt="imgen-destino">
                                    <p class="ciudad-bold">NOM CIUDAD</p>
                                    <p>X alojamientos</p>
                                </a>
                            </div>
                        
                    
                        
                    
                    
                </div>
                <button class="boton-carrusel" id="siguiente" onclick="cambiarFoto(1)">❯</button>
                
    
            </div>
            
            <section class="destino-filtros">
                <h2>Planificador de viajes rápido</h2>
                <div class="filtros-contenedor">
                        
                            <button class="boton-bg-blanco-shadow" href="">
                                <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                    <path d="M12.541 21.325l-9.588-10a4.923 4.923 0 1 1 6.95-6.976l1.567 1.566a.75.75 0 0 0 1.06 0l1.566-1.566a4.923 4.923 0 0 1 6.963 6.962l-9.6 10.014h1.082zm-1.082 1.038a.75.75 0 0 0 1.082 0l9.59-10.003a6.418 6.418 0 0 0-.012-9.07 6.423 6.423 0 0 0-9.083-.001L11.47 4.854h1.06l-1.566-1.566a6.423 6.423 0 1 0-9.082 9.086l9.577 9.99z"></path>
                                    </svg></span>
                                <span>Amor</span>
                            </button>       
                        
        
                        
                            <button class="boton-bg-blanco-shadow" href="">
                                <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                    <path d="M2.75 6h9.5a.25.25 0 0 1-.25-.25v17.5l.75-.75H2.25l.75.75V5.75a.25.25 0 0 1-.25.25zm0-1.5c-.69 0-1.25.56-1.25 1.25v17.5c0 .414.336.75.75.75h10.5a.75.75 0 0 0 .75-.75V5.75c0-.69-.56-1.25-1.25-1.25h-9.5zm3-1.5h3.5A.25.25 0 0 1 9 2.75v2.5l.75-.75h-4.5l.75.75v-2.5a.25.25 0 0 1-.25.25zm0-1.5c-.69 0-1.25.56-1.25 1.25v2.5c0 .414.336.75.75.75h4.5a.75.75 0 0 0 .75-.75v-2.5c0-.69-.56-1.25-1.25-1.25h-3.5zM5.25 9h4.5a.75.75 0 0 0 0-1.5h-4.5a.75.75 0 0 0 0 1.5zm0 3h4.5a.75.75 0 0 0 0-1.5h-4.5a.75.75 0 0 0 0 1.5zm0 3h4.5a.75.75 0 0 0 0-1.5h-4.5a.75.75 0 0 0 0 1.5zm0 3h4.5a.75.75 0 0 0 0-1.5h-4.5a.75.75 0 0 0 0 1.5zm0 3h4.5a.75.75 0 0 0 0-1.5h-4.5a.75.75 0 0 0 0 1.5zM7.5.75v1.5a.75.75 0 0 0 1.5 0V.75a.75.75 0 0 0-1.5 0zM15.75 24h6a.75.75 0 0 0 .75-.75V10.5A1.5 1.5 0 0 0 21 9h-4.5a1.5 1.5 0 0 0-1.5 1.5v12.75a.75.75 0 0 0 1.5 0V10.5H21v12.75l.75-.75h-6a.75.75 0 0 0 0 1.5zM19.5 8.25v1.5a.75.75 0 0 0 1.5 0v-1.5a.75.75 0 0 0-1.5 0zM.75 24h22.5a.75.75 0 0 0 0-1.5H.75a.75.75 0 0 0 0 1.5z"></path>
                                    </svg>
                                </span>
                                <span>Ciudad</span>
                            </button>   
                        
        
                        
                            <button class="boton-bg-blanco-shadow" href="flights/index.html">
                                <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                    <path d="M.153 22.237l.85 1.117c.634.76 1.724.856 2.456.244.078-.066.15-.138.216-.217l.944-1.132a.228.228 0 0 1 .349.001l.944 1.13a1.728 1.728 0 0 0 2.651.001l.944-1.132a.228.228 0 0 1 .349.001l.95 1.132a1.728 1.728 0 0 0 2.65 0l.942-1.133a.228.228 0 0 1 .349.001l.942 1.13a1.728 1.728 0 0 0 2.651.001l.944-1.132a.228.228 0 0 1 .349.001l.94 1.13a1.728 1.728 0 0 0 2.652.001l.585-.7a.75.75 0 1 0-1.15-.962l-.585.7a.228.228 0 0 1-.35 0l-.94-1.13a1.728 1.728 0 0 0-2.652-.001l-.944 1.132a.228.228 0 0 1-.349-.001l-.942-1.13a1.728 1.728 0 0 0-2.651-.001l-.943 1.132a.228.228 0 0 1-.348-.001l-.95-1.132a1.726 1.726 0 0 0-2.65 0l-.944 1.133a.228.228 0 0 1-.349-.001l-.944-1.13a1.728 1.728 0 0 0-2.65 0l-.945 1.13a.228.228 0 0 1-.349-.001l-.828-1.09a.75.75 0 1 0-1.194.91zm11.335-2.68A7.161 7.161 0 0 1 15.77 18h7.481a.75.75 0 0 0 0-1.5h-7.5a8.673 8.673 0 0 0-5.196 1.884.75.75 0 1 0 .934 1.174zM22.285 7.969a1.729 1.729 0 0 0 .781-2.711C19.43.713 12.8-.022 8.256 3.614a10.536 10.536 0 0 0-3.952 8.171A1.73 1.73 0 0 0 6.6 13.427l15.684-5.459zm-.494-1.416L6.107 12.01a.229.229 0 0 1-.304-.218 9.036 9.036 0 0 1 16.09-5.599.228.228 0 0 1-.102.359zm-9.459-4.2L11.69.504a.75.75 0 1 0-1.416.492l.643 1.848a.75.75 0 1 0 1.416-.492zm1.156 7.883l2.527 7.262a.75.75 0 1 0 1.416-.494l-2.527-7.26a.75.75 0 1 0-1.416.492z"></path>
                                    </svg>
                                </span>
                                <span>Playa</span>
                                </button>   
                       
        
                        
                            <button class="boton-bg-blanco-shadow" href="flights/index.html">
                                <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                    <path d="M16.5 3.75a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm1.5 0a3 3 0 1 0-6 0 3 3 0 0 0 6 0zm-10.5 15a3 3 0 1 1-6 0 3 3 0 0 1 6 0zm1.5 0a4.5 4.5 0 1 0-9 0 4.5 4.5 0 0 0 9 0zm13.5 0a3 3 0 1 1-6 0 3 3 0 0 1 6 0zm1.5 0a4.5 4.5 0 1 0-9 0 4.5 4.5 0 0 0 9 0zm-12 .75a.75.75 0 0 1-.75-.75 6.734 6.734 0 0 0-3.642-5.994.75.75 0 0 1-.167-1.207l4.043-3.842a.75.75 0 0 1 1.187.208c.062.116.143.252.263.429.197.289.429.577.697.848.8.809 1.758 1.308 2.869 1.308a.75.75 0 0 1 0 1.5 5.564 5.564 0 0 1-4.137-1.966.75.75 0 0 0-1.089-.058l-1.452 1.38a.75.75 0 0 0 .031 1.116 8.22 8.22 0 0 1 2.897 6.277.75.75 0 0 1-.75.751zm0 1.5a2.25 2.25 0 0 0 2.25-2.25 9.72 9.72 0 0 0-3.425-7.421l.03 1.114 1.453-1.38-1.089-.059a7.07 7.07 0 0 0 5.268 2.496A2.25 2.25 0 1 0 16.5 9c-.656 0-1.26-.315-1.803-.863a4.554 4.554 0 0 1-.695-.914 2.25 2.25 0 0 0-3.552-.604l-4.043 3.842a2.25 2.25 0 0 0 .51 3.626 5.236 5.236 0 0 1 2.833 4.662A2.25 2.25 0 0 0 12 21z"></path>
                                    </svg>
                                </span>
                                <span>Aire libre</span>
                                </button>   
                        
        
                        
                            <button class="boton-bg-blanco-shadow" href="flights/index.html">
                                <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                    <path d="M15.62 6.45a3.14 3.14 0 1 0-3.13-3.14 3.15 3.15 0 0 0 3.13 3.14Zm0-4.77A1.64 1.64 0 1 1 14 3.31a1.64 1.64 0 0 1 1.62-1.63ZM23.26 18.64a.74.74 0 0 0-1-.31l-.33.17-3.59-6.69a2.19 2.19 0 0 0 .48-1.37 2.25 2.25 0 0 0-2.24-2.26h-1.89l-1.84-2a3.5 3.5 0 0 0-4.53-.58L3.7 8.71A3.05 3.05 0 0 0 4 14l2.82 1.47-1.14 1.21a2.33 2.33 0 0 0-.56 1.25l-3.38-1.69a.75.75 0 0 0-1 .33.76.76 0 0 0 .34 1L13 23.52a2.78 2.78 0 0 0 1.26.3 2.74 2.74 0 0 0 1.33-.34l.82-.45a.75.75 0 0 0-.72-1.32l-.82.46a1.3 1.3 0 0 1-1.2 0l-4.78-2.36.11-.12 2.6-2.89a2.81 2.81 0 0 0-.8-4.37l-2.6-1.35 1.9-1.26 1.9 2.12a2.22 2.22 0 0 0 1.66.74h2.86a2 2 0 0 0 .5-.06l3.58 6.58-.54.29a.75.75 0 0 0-.31 1 .74.74 0 0 0 .66.39.72.72 0 0 0 .35-.08l.55-.3.44.83a.77.77 0 0 0 .67.4.73.73 0 0 0 .35-.09.76.76 0 0 0 .31-1l-.45-.82.32-.17a.75.75 0 0 0 .31-1.01Zm-6.7-7.46H13.7a.77.77 0 0 1-.56-.25l-2.51-2.76a.5.5 0 0 0-.63-.08l-3.79 2.54a.61.61 0 0 0 0 1l3.88 2.09a1.31 1.31 0 0 1 .69.92 1.28 1.28 0 0 1-.31 1.11l-2.56 2.93a.71.71 0 0 1-.55.25.77.77 0 0 1-.51-.19.76.76 0 0 1 0-1.06l1.79-2a.73.73 0 0 0-.21-1.15l-3.74-1.91A1.56 1.56 0 0 1 4.54 10l4.62-3.16a2 2 0 0 1 2.58.32L14 9.68h2.54a.75.75 0 0 1 0 1.5Z"></path>
                                    </svg>
                                </span>
                                <span>Esqui</span>
                            </button>   
                        
        
                        
                            <button class="boton-bg-blanco-shadow" href="flights/index.html">
                                <span><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                                    <path d="M11.72 14.295A7.35 7.35 0 0 1 8.997 8.85a7.148 7.148 0 0 1 2.25-4.972c.005-.005-.004-.005-.01-.01a7.173 7.173 0 0 1 2.261 5.03 7.332 7.332 0 0 1-2.722 5.397h.944zm-.944 1.166a.75.75 0 0 0 .944 0 8.85 8.85 0 0 0 3.277-6.555 8.683 8.683 0 0 0-2.72-6.12 1.482 1.482 0 0 0-2.069.01 8.658 8.658 0 0 0-2.71 6.062 8.869 8.869 0 0 0 3.278 6.603zm3.813-7.013A7.807 7.807 0 0 1 19.023 7.1l.003-.001a7.17 7.17 0 0 1-1.959 5.142 7.332 7.332 0 0 1-5.74 1.891.75.75 0 0 0-.158 1.492 8.85 8.85 0 0 0 6.953-2.318 8.68 8.68 0 0 0 2.404-6.233A1.495 1.495 0 0 0 19.029 5.6a9.304 9.304 0 0 0-5.282 1.608.75.75 0 1 0 .842 1.24zM8.75 7.221A9.239 9.239 0 0 0 3.417 5.6c-.815-.001-1.484.664-1.49 1.488a8.652 8.652 0 0 0 2.37 6.184 8.95 8.95 0 0 0 7.031 2.35.75.75 0 1 0-.158-1.49 7.431 7.431 0 0 1-5.82-1.927 7.142 7.142 0 0 1-1.923-5.091L3.426 7.1a7.746 7.746 0 0 1 4.476 1.357.75.75 0 0 0 .848-1.236zm-4.944 3.966c-2.223.948-3.808 2.716-3.808 4.441 0 3.47 5.422 6 12 6a22.404 22.404 0 0 0 6.977-1.047.75.75 0 0 0 .523-.715v-3.488l-.75.75h4.383a.75.75 0 0 0 .715-.524c.1-.315.15-.643.152-.973 0-2.068-1.986-3.858-5.079-4.944a.75.75 0 1 0-.497 1.416c2.56.898 4.076 2.265 4.076 3.525 0 .176-.028.354-.082.524l.715.226v-.75h-4.383a.75.75 0 0 0-.75.75v3.488l.523-.715a20.922 20.922 0 0 1-6.516.977c-5.856 0-10.507-2.17-10.507-4.5 0-1.02 1.17-2.325 2.896-3.061a.75.75 0 0 0-.588-1.38z"></path>
                                    </svg>
                                </span>
                                <span>Relax</span>
                            </button>   
                        
                    

                </div>
                <div class="carrusel-fotos">
                    <button class="boton-carrusel" id="anterior" onclick="cambiarFoto(-1)">❮</button>
                    <div class="container-fotos">
                        
                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/barcelona.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>
                            
                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/caceres.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>
                            
                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/madrid.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>
                            
                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/madrid.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>
                           
                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/madrid.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>
                            
                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/madrid.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>
                            
                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/madrid.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>

                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/madrid.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>

                                <div class="card-foto">
                                    <a href="">
                                        <img src="img/madrid.jpg" alt="imgen-destino">
                                        <p class="ciudad-bold">NOM CIUDAD</p>
                                        <p>X alojamientos</p>
                                    </a>
                                </div>
                            
                        
                            
                        
                        
                    </div>
                    <button class="boton-carrusel" id="siguiente" onclick="cambiarFoto(1)">❯</button>
                    
        
                </div>
            </section>
        
    </div>
