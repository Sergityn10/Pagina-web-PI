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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.*;
import es.unex.pi.model.*;

/**
 * Servlet implementation class chooseAlojamiento
 */
@WebServlet( urlPatterns = {"/chooseAlojamientoServlet.do"})
public class chooseAlojamientoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chooseAlojamientoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO propDao = new JDBCPropertyDAOImpl();
		propDao.setConnection(conn);
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//TODO Descomentar cuando este implementado la funcionalidad de inicio de sesión
		long idu = user.getId();
		Long id = Long.parseLong(request.getParameter("id"));
		Property prop = propDao.get(id);
		request.setAttribute("prop", prop); //Guardamos en la request la propiedad a la que se está accediendo y la que se quiere mostrar 
		
		boolean conReview = false;
		HashMap<Review, User> reviewUser = new HashMap<Review, User>();
		List<Review> reviewsList=reviewDao.getAllByProperty(id);
		for(Review itReview : reviewsList) {
			User itUser = new User();
			itUser = userDao.get(itReview.getIdu());
			reviewUser.put(itReview, itUser);
			//TODO DEscomentar cuando este implementado la funcion de iniciar sesión
			//if(itReview.getIdu() == user.getId()) {
			if(itReview.getIdu() == idu) {
				conReview = true;
				request.setAttribute("ownReview", itReview); 
			}
		}
		
		AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
		accomDao.setConnection(conn);
		
		
	
		List<Accommodation> AccomList = new ArrayList<Accommodation>();
		AccomList = accomDao.getAllBySearchIdp(prop.getId());
		
		
		request.setAttribute("accomList", AccomList);
		request.setAttribute("conReview", conReview);
		request.setAttribute("reviewUser", reviewUser); //Guardamos en la request la lista de review que tiene el alojamiento buscado por el usuario
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/detalleAlojamiento.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

