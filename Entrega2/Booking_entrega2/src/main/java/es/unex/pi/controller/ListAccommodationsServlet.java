package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.AccommodationDAO;
import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.model.Accommodation;
import es.unex.pi.model.Property;

/**
 * Servlet implementation class ListAccommodationsServlet
 */
public class ListAccommodationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAccommodationsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("ListAccomodations GET");

		Long idA = Long.parseLong(request.getParameter("idp"));
		
		logger.info("Identificador alojamiento:"+idA);

		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		AccommodationDAO habitacionDao = new JDBCAccommodationDAOImpl();
		habitacionDao.setConnection(conn);

		List<Accommodation> listaHabitaciones = habitacionDao.getAllBySearchIdp(idA);
		
		request.setAttribute("listaHabitaciones", listaHabitaciones);
		
		//Se obtiene el alojamiento para también poder pasarlo por la request
		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);
		
		Property alojamiento = alojamientoDao.get(idA);
		
		request.setAttribute("alojamiento", alojamiento);
		
		// Se envía a la página de listado de habitaciones
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/listaHabitaciones.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
