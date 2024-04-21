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
import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.model.Accommodation;
import es.unex.pi.model.Property;

/**
 * Servlet implementation class DeleteAccommodationServlet
 */

@WebServlet( urlPatterns = {"/DeleteAccommodationServlet.do"})

public class DeleteAccommodationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccommodationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("DeleteAccommodation GET");
		
		// Se obtiene el id del alojamiento pasado en la request
		Long idH = Long.parseLong(request.getParameter("ida"));
		
		//Se recupera el objeto
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		AccommodationDAO habitacionDao = new JDBCAccommodationDAOImpl();
		habitacionDao.setConnection(conn);
		
		Accommodation habitacion = habitacionDao.get(idH);
		
		//Se pasa a través de la request
		request.setAttribute("habitacion", habitacion);

		// Se envía a la página de confirmar eliminación
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/confirmEliminarHabitacion.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("DeleteAccommodation POST");

		// Se obtiene el id del alojamiento pasado en la request
		Long idH = Long.parseLong(request.getParameter("idH"));

		// Se elimina el atributo de la BD
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");

		AccommodationDAO habitacionDao = new JDBCAccommodationDAOImpl();
		habitacionDao.setConnection(conn);
		
		habitacionDao.delete(idH);
		
		RequestDispatcher view = request.getRequestDispatcher("InicioBookingServlet.do");
		view.forward(request, response);
	}

}
