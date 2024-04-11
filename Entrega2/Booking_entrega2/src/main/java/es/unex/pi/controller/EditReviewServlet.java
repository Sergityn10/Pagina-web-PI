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

import es.unex.pi.dao.JDBCReviewDAOImpl;
import es.unex.pi.dao.ReviewDAO;
import es.unex.pi.model.Review;
import es.unex.pi.model.User;

/**
 * Servlet implementation class EditReviewServlet
 * 
 */
@WebServlet( urlPatterns = {"/reviews/EditReviewServlet.do"})
public class EditReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
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
		//TODO Descomentar cuando este implementando la función de iniciar sesión
		long idu = user.getId();
		Review review = new Review ();
		
		int grade = Integer.parseInt(request.getParameter("num_valoracion"));
		review.setGrade(grade);
		review.setIdp(idp);
		review.setIdu(idu); //CAMBIAR CUANDO CONFIRME QUE VA LA FUNCIÓN DE CREACIÓN DE REVIEWS
		review.setReview(request.getParameter("descripcion"));
		
		reviewDao.update(review);
		response.sendRedirect("../chooseAlojamientoServlet.do?id="+idp);
		
	}

}
