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
@WebServlet( urlPatterns = {"/RegisterServlet.do"})
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Register GET ");
		
		//Se comprueba que no haya ningún user en la sesión
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}
		
		//Se manda al registro
		RequestDispatcher view = request.getRequestDispatcher("registro.html");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Register POST");
		
		//Se le pasan los atributos al objeto
		User user = new User(); 
		
		user.setName(request.getParameter("nombre"));
		user.setSurname(request.getParameter("apellidos"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		//Se añade a la BD
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);
		
		userDAO.add(user);
		
		user=null;
		
		//Redirección al Servlet de inicio de sesión, el get solo muestra la página
		response.sendRedirect("InicioBookingServlet.do");
	}

}
