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
import java.util.HashMap;
import java.util.List;

import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCReviewDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.ReviewDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Property;
import es.unex.pi.model.Review;
import es.unex.pi.model.User;

/**
 * Servlet implementation class ListReviewsServlet
 * 
 */
@WebServlet( urlPatterns = {"/reviews/ListReviewsServlet.do"})
public class ListReviewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListReviewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO propDao = new JDBCPropertyDAOImpl();
		propDao.setConnection(conn);
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		HashMap<Review, Property> reviewProp = new HashMap<Review,Property >();
		//TODO Descomentar cuando la funcionalidad de iniciar sesión este implementada
		//List<Review> reviewList=reviewDao.getAllByUser(user.getId());
		List<Review> reviewList=reviewDao.getAllByUser(1);
		for(Review itReview : reviewList) {
			Property itProp = new Property();
			itProp = propDao.get(itReview.getIdp());
			reviewProp.put(itReview, itProp);
			
			
		}
		
		request.setAttribute("listReviews", reviewProp);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/User/ListOwnReviews.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
