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

import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.User;

/**
 * Servlet implementation class DeleteUserServlet
 */

@WebServlet( urlPatterns = {"/users/DeleteUserServlet.do"})
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("DeleteUser GET");

		// Se envía a la página de confirmar eliminación
		RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/confirmEliminarUsuario.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Si se ha llegado aquí es que se confirma la eliminación
		logger.info("DeleteUser POST");

		// Se elimina el atributo de la BD
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Connection conn = (Connection) getServletContext().getAttribute("dbConn");

		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		long id = user.getId();
		userDAO.delete(id);

		// Se elimina también de la sesión
		session.removeAttribute("user");

		RequestDispatcher view = request.getRequestDispatcher("../InicioBookingServlet.do");
		view.forward(request, response);
	}

}
