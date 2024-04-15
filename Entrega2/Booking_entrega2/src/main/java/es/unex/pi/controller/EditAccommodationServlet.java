package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

import es.unex.pi.dao.AccommodationDAO;
import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.model.Accommodation;
import es.unex.pi.model.Property;
import es.unex.pi.model.User;

/**
 * Servlet implementation class EditAccommodationServlet
 */
@WebServlet( urlPatterns = {"/EditAccommodationServlet.do"})
public class EditAccommodationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccommodationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("EditAccommodation GET");
		
		logger.info("EditProperty GET");

		// Se obtiene el id del alojamiento pasado en la request
		Long idH = Long.parseLong(request.getParameter("ida"));

		// Se recupera el objeto
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		AccommodationDAO habitacionDao = new JDBCAccommodationDAOImpl();
		habitacionDao.setConnection(conn);

		Accommodation habitacion = habitacionDao.get(idH);

		// Se pasa a través de la request
		request.setAttribute("habitacion", habitacion);

		// Se envía a la página de confirmar eliminación
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/editarHabitacion.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("EditAccommodation POST");
		
		//Se recupera el id pasado a través de la request
		
		Accommodation habitacion = new Accommodation();
		
		habitacion.setId(Long.parseLong(request.getParameter("idH")));
		habitacion.setName(request.getParameter("nombre"));
		habitacion.setDescription(request.getParameter("descripcion-hab"));
		habitacion.setPrice(Integer.parseInt(request.getParameter("precio-hab")));
		habitacion.setNumAccommodations(Integer.parseInt(request.getParameter("disponibles")));
		habitacion.setIdp(Long.parseLong(request.getParameter("idA")));

		// Se actualiza en la BD con el DAO
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		AccommodationDAO habitacionDao = new JDBCAccommodationDAOImpl();
		habitacionDao.setConnection(conn);

		if (habitacionDao.update(habitacion))
			logger.info("EditAccommodation POST: Cambios realizados correctamente");

		else
			logger.info("EditAccommodation POST: Fallo al actualizar la habitación");
		
		RequestDispatcher view = request.getRequestDispatcher("InicioBookingServlet.do");
		view.forward(request, response);
	}

}
