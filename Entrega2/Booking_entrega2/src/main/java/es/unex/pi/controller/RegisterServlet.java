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
 * Servlet implementation class RegisterServlet
 * 
 */
@WebServlet(urlPatterns = { "/RegisterServlet.do" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Register GET ");

		// Se comprueba que no haya ningún user en la sesión
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}

		// Se manda al registro
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/registro.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Register POST");

		// Se obtiene el email para comprobar que no se encuentre en la BD
		String email = request.getParameter("email");

		Connection conn = (Connection) getServletContext().getAttribute("dbConn");

		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);

		User userAux = userDAO.getByEmail(email);
		if (userAux == null) {
			logger.info("Register POST -> Se añade el usuario a la BD");

			// Se le pasan los atributos al objeto
			User user = new User();

			user.setName(request.getParameter("nombre"));
			user.setSurname(request.getParameter("apellidos"));
			user.setEmail(email);
			user.setPassword(request.getParameter("password"));

			// Se añade a la BD
			userDAO.add(user);

			user = null;

			// Redirección al Servlet de inicio de sesión, el get solo muestra la página
			response.sendRedirect("InicioBookingServlet.do");

		} else {
			logger.info("Register POST -> ERROR, ya había un usuario con ese correo en la BD");

			String mensajeError = "Error: El correo electrónico ya se encuentra en uso";
			request.setAttribute("mensaje_error", mensajeError);

			// Se manda al registro
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/registro.jsp");
			view.forward(request, response);
		}
	}

}
