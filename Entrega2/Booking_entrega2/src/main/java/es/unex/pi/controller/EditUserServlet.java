package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.PageContext;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Logger;

import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.User;

/**
 * Servlet implementation class EditUserServlet
 */

@WebServlet( urlPatterns = {"/users/EditUserServlet.do"})
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("EditUser GET");

		RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/editarUsuario.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
logger.info("EditUser POST");
		
		//Se obtienen los datos del formulario
		String name = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//Se recupera el usuario actual de la sesión
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//Se actualiza el usuario
		user.setName(name);
		user.setSurname(apellidos);
		user.setEmail(email);
		user.setPassword(password);
		
		//Se actualiza en la BD con el DAO
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);
		
		if (userDAO.update(user)) {
			logger.info("EditUser POST: Cambios realizados correctamente");
			
			//Se actualiza el user de la sesión
			session.removeAttribute("user");
			session.setAttribute("user", user);
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/index.jsp");
			view.forward(request, response);
		}
		else {
			logger.info("EditUser POST: Fallo al actualizar el usuario");
			
			//Se manda a la página de mensajes
			String mensajeError = "No ha sido posible actualizar la información";
			
			request.setAttribute("mensaje", mensajeError);
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/index.jsp");
			view.forward(request, response);
		}
	}

}
