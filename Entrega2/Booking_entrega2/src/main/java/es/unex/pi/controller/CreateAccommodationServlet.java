package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

import es.unex.pi.dao.AccommodationDAO;
import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.model.Accommodation;

/**
 * Servlet implementation class CreateAccommodationServlet
 */

@WebServlet( urlPatterns = {"/CreateAccommodationServlet.do"})
public class CreateAccommodationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccommodationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//En teoría aquí no se va a llegar nunca
		logger.info("CreateAccommodaion GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("CreateAccommodaion POST");
		
		Accommodation habitacion = new Accommodation();
		
		habitacion.setName(request.getParameter("nombre"));
		habitacion.setDescription(request.getParameter("descripcion-hab"));
		habitacion.setPrice(Integer.parseInt(request.getParameter("precio-hab")));
		habitacion.setNumAccommodations(Integer.parseInt(request.getParameter("disponibles")));
		habitacion.setIdp(Long.parseLong(request.getParameter("idp")));
		
		//Se añade a la BD
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		
		AccommodationDAO habitacionDao = new JDBCAccommodationDAOImpl();
		habitacionDao.setConnection(conn);
		
		habitacionDao.add(habitacion);
		
		//Redirección de nuevo a la lista de propiedades del usuario
		RequestDispatcher view = request.getRequestDispatcher("InicioBookingServlet.do");
	    view.forward(request, response);	
	}

}
