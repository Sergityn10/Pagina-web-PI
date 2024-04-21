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

import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Property;
import es.unex.pi.model.User;

/**
 * Servlet implementation class DeletePropertyServlet
 */

@WebServlet( urlPatterns = {"/DeletePropertyServlet.do"})

public class DeletePropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePropertyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("DeleteProperty GET");
		
		// Se obtiene el id del alojamiento pasado en la request
		Long idA = Long.parseLong(request.getParameter("idp"));
		
		//Se recupera el objeto
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);
		
		Property alojamiento = alojamientoDao.get(idA);
		
		//Se pasa a través de la request
		request.setAttribute("alojamiento", alojamiento);

		// Se envía a la página de confirmar eliminación
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/confirmEliminarAlojamiento.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("DeleteProperty POST");

		// Se obtiene el id del alojamiento pasado en la request
		Long idA = Long.parseLong(request.getParameter("idA"));

		// Se elimina el atributo de la BD
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");

		PropertyDAO alojamientoDAO = new JDBCPropertyDAOImpl();
		alojamientoDAO.setConnection(conn);
		
		alojamientoDAO.delete(idA);
		
		RequestDispatcher view = request.getRequestDispatcher("InicioBookingServlet.do");
		view.forward(request, response);
	}

}
