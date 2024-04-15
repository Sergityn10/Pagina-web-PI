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
 * Servlet implementation class EditPropertyServlet
 */
public class EditPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPropertyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("EditProperty GET");

		// Se obtiene el id del alojamiento pasado en la request
		Long idA = Long.parseLong(request.getParameter("idp"));

		// Se recupera el objeto
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		Property alojamiento = alojamientoDao.get(idA);

		// Se pasa a través de la request
		request.setAttribute("alojamiento", alojamiento);

		// Se envía a la página de confirmar eliminación
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/editarAlojamiento.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("EditProperty POST");

		Property alojamiento = new Property();
		
		alojamiento.setId(Long.parseLong(request.getParameter("idp")));
		alojamiento.setName(request.getParameter("nombre"));
		alojamiento.setCity(request.getParameter("ciudad"));
		alojamiento.setAddress(request.getParameter("direccion"));
		alojamiento.setTelephone(request.getParameter("telefono"));
		alojamiento.setCenterDistance(Float.parseFloat(request.getParameter("distancia")));
		alojamiento.setGradesAverage(Float.parseFloat(request.getParameter("valoracion")));
		alojamiento.setDescription(request.getParameter("descripcion"));
		// Faltaría las mascotas
		
		//Se obtiene el usuario de la sesión y se coge su id
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		alojamiento.setIdu((int) user.getId());

		// Se actualiza en la BD con el DAO
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		if (alojamientoDao.update(alojamiento))
			logger.info("EditProperty POST: Cambios realizados correctamente");

		else
			logger.info("EditProperty POST: Fallo al actualizar el usuario");
		
		RequestDispatcher view = request.getRequestDispatcher("InicioBookingServlet.do");
		view.forward(request, response);
	}

}
