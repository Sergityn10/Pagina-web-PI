package es.unex.pi.controller;

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
import es.unex.pi.model.User;

/**
 * Servlet implementation class DeleteReviewServlet
 * 
 */
@WebServlet( urlPatterns = {"/reviews/DeleteReviewServlet.do"})
public class DeleteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReviewServlet() {
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
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		long idp = Long.parseLong(request.getParameter("idp"));
		//TODO Cambiar la funcionalidad de conseguir el id del usuario mediante la sesión cuando mi Juampi la termine. Descomentar la linea siguiente
		//long idu = user.getId();
		long idu = 1;
		
		if(reviewDao.get(idp, idu) != null) {
			reviewDao.delete(idp, idu);
			
		}
		response.sendRedirect("ListReviewsServlet.do");
	}

}
