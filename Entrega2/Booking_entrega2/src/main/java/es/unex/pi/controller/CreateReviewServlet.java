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

import es.unex.pi.dao.*;
import es.unex.pi.model.*;


/**
 * Servlet implementation class CreateReviewServlet
 */
@WebServlet( urlPatterns = {"/reviews/CreateReviewServlet.do"})
public class CreateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);
		Review review = new Review ();
		Property prop = (Property) request.getAttribute("prop");
		int grade = Integer.parseInt(request.getParameter("num_valoracion"));
		review.setGrade(grade);
		review.setIdp(prop.getId());
		review.setIdu(1); //CAMBIAR CUANDO CONFIRME QUE VA LA FUNCIÓN DE CREACIÓN DE REVIEWS
		review.setReview(request.getParameter("descripcion"));
		
		if(reviewDao.get(prop.getId(), 1) == null) {
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		long idp = Long.parseLong(request.getParameter("idp"));
		Review review = new Review ();
		
		int grade = Integer.parseInt(request.getParameter("num_valoracion"));
		review.setGrade(grade);
		review.setIdp(idp);
		review.setIdu(9); //CAMBIAR CUANDO CONFIRME QUE VA LA FUNCIÓN DE CREACIÓN DE REVIEWS
		review.setReview(request.getParameter("descripcion"));
		
		
		if(reviewDao.get(review.getIdp(), review.getIdu()) == null) {
			logger.info("No existe ningún review realizada sobre este alojamiento por este usuario ");
			reviewDao.add(review);
			response.sendRedirect("../chooseAlojamientoServlet.do?id="+idp);
		}
		/*
		 * else { request.setAttribute("message",
		 * "Lo sentimos, no puedes realizar más valoraciones a este alojamiento. Si has cambiado de opinión sobre este alojamiento, edita la valoración ya realizada"
		 * ); RequestDispatcher view =
		 * request.getRequestDispatcher("/WEB-INF/detalleAlojamiento.jsp");
		 * view.forward(request, response); }
		 */
	}

}
