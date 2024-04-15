package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.CategoryDAO;
import es.unex.pi.dao.JDBCCategoryDAOImpl;
import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCPropertyUserDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.PropertyUserDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.Property;
import es.unex.pi.model.User;

/**
 * Servlet implementation class CreatePropertyServlet
 */
public class CreatePropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("CreatePropertie GET");
		
		//Se recogen todas las categorias a través del DAO
		CategoryDAO categoriaDao = new JDBCCategoryDAOImpl();
		
		List<Category> categorias = categoriaDao.getAll();
		
		request.setAttribute("categorias", categorias);
		
		//Se envía a la página de creación del restaurante		
		ServletContext context = request.getServletContext();
		String rutaRecurso = "/WEB-INF/añadirAlojamiento.jsp";

		RequestDispatcher view = context.getRequestDispatcher(rutaRecurso);
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("CreatePropertie POST");
		
		//Se crea el objeto Property con los valores recogidos del form
		Property alojamiento = new Property();
		
		alojamiento.setName(request.getParameter("nombre"));
		alojamiento.setAddress(request.getParameter("direccion"));
		alojamiento.setTelephone(request.getParameter("telefono"));
		alojamiento.setGradesAverage(Float.parseFloat(request.getParameter("valoracion")));
		alojamiento.setCity(request.getParameter("localidad"));
		alojamiento.setCenterDistance(Float.parseFloat(request.getParameter("distancia")));
		alojamiento.setDescription(request.getParameter("descripcion"));
		
		//Se comprueba si el String de mascotas es si (1) o no (0)
		String mascotas = request.getParameter("mascotas");
		if(mascotas == "si")
			alojamiento.setPetFriendly(1);
		else if (mascotas == "no")
			alojamiento.setPetFriendly(0);
		
		//Inicialmente se crean los alojamientos con disponibilidad 1
		alojamiento.setAvailable(1);
		
		// En la BD no está contemplado los servicios
		//String[] servicios = request.getParameterValues("servicios");

		//Se obtiene el usuario de la sesión
		HttpSession session = request.getSession();
		User usuario = (User) session.getAttribute("user");
		
		//Se le almacena el id usuario en el alojamiento
		alojamiento.setIdu((int )usuario.getId());
		
		//Se añade el plato a la BD a través del DAO
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		
		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);
		
		alojamientoDao.add(alojamiento);
		
		//Redirección de nuevo a la lista de propiedades del usuario
		RequestDispatcher view = request.getRequestDispatcher("InicioBookingServlet.do");
	    view.forward(request, response);
	}

}
