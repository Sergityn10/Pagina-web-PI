package es.unex.pi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import es.unex.pi.model.*;
import es.unex.pi.*;
import es.unex.pi.dao.JDBCPropertyUserDAOImpl;
import es.unex.pi.dao.PropertyUserDAO;
/**
 * Servlet implementation class SavePropertyFavoriteServlet
 */
@WebServlet( urlPatterns = {"/favorites/SavePropertyFavoriteServlet.do"})
public class SavePropertyFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePropertyFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyUserDAO favoriteDao = new JDBCPropertyUserDAOImpl();
		favoriteDao.setConnection(conn);
		
		propertyUser newFavorite = new propertyUser();
		
		long idp = Long.parseLong(request.getParameter("idp"));
		long idu = Long.parseLong(request.getParameter("idu"));
		newFavorite.setIdp(idp);
		newFavorite.setIdu(idu);
		
		if(favoriteDao.get(idp, idu) == null) {
			favoriteDao.add(newFavorite);
			response.sendRedirect("SearchServlet.do");
		}
		else {
			
		}
		
	}

}
