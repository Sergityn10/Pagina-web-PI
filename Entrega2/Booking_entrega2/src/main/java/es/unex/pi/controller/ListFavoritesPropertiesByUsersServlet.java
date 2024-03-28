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
import java.util.List;

import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCPropertyUserDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.PropertyUserDAO;
import es.unex.pi.model.Property;
import es.unex.pi.model.User;
import es.unex.pi.model.propertyUser;
import es.unex.pi.*;

/**
 * Servlet implementation class ListFavoritesPropertiesByUsersServlet
 */
@WebServlet( urlPatterns = {"/favorites/ListFavoritesPropertiesByUsersServlet.do"})
public class ListFavoritesPropertiesByUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFavoritesPropertiesByUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		PropertyUserDAO favoriteDao = new JDBCPropertyUserDAOImpl();
		favoriteDao.setConnection(conn);
		
		PropertyDAO propDao = new JDBCPropertyDAOImpl();
		propDao.setConnection(conn);
		
		List<Property> listProps = new ArrayList<Property>();
		//for(propertyUser itPropUser: favoriteDao.getAllByUser(user.getId())) {
		for(propertyUser itPropUser: favoriteDao.getAllByUser(1)) {
			Property itProp = new Property();
			itProp=propDao.get(itPropUser.getIdp());
			listProps.add(itProp);
		}
		request.setAttribute("listFavorites", listProps);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/User/ListFavoritesProperties.jsp");
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
