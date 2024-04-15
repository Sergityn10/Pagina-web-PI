package es.unex.pi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.*;
import es.unex.pi.*;
import es.unex.pi.dao.JDBCPropertyUserDAOImpl;
import es.unex.pi.dao.PropertyUserDAO;
import es.unex.pi.model.User;
import es.unex.pi.model.propertyUser;

import java.io.IOException;

/**
 * Servlet implementation class addFavoritePropertyUserServlet
 */
@WebServlet( urlPatterns = {"/favorites/addFavoritePropertyUserServlet.do"})
public class addFavoritePropertyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFavoritePropertyUserServlet() {
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
		PropertyUserDAO favoriteDao = new JDBCPropertyUserDAOImpl();
		favoriteDao.setConnection(conn);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		//TODO Descomentar cuando este implementado la funcionalidad de inicio de sesión
		//long idu = user.getId();
		long idu = 1;
		long idp = Long.parseLong(request.getParameter("idp"));
		
		propertyUser newFavorite = new propertyUser();
		
		newFavorite.setIdp(idp);
		newFavorite.setIdu(idu);
		
		if(favoriteDao.get(idp, idu) == null) {
			favoriteDao.add(newFavorite);
		}
		else {
			//TODO eliminar 
			
		}
		response.sendRedirect("ListFavoritesPropertiesByUsersServlet.do");
		
		
	}

}
