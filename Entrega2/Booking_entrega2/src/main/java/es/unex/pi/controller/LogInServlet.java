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
 * Servlet implementation class LogInServlet
 * 
 * 
 */
@WebServlet( urlPatterns = {"/LogInServlet.do"})
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("LogIn GET");
		
		//Se manda a la página de inicio de sesión
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/login.jsp");
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Inicio POST");
		
		//Se obtiene los input y se comprueba que exista el usuario
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);
		
		User user = userDAO.getByEmailPassword(email, password);
		if(user != null) {
			logger.info("Inicio POST -> Usuario encontrado en la BD");
			
			//Una vez encontrado se le pasa el usuario a la sesión
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/index.jsp");
			view.forward(request, response);
		}
		else {
			logger.info("Inicio POST -> Usuario NO encontrado en la BD");
			
			//Se pasa el mensaje de error a mostrar
			request.setAttribute("mensajeError", "Usuario o contraseña no válidos. Por favor, inténtelo de nuevo");
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/login.jsp");
			view.forward(request, response);
		}
	}

}
