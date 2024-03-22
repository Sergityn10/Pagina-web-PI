package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import es.unex.pi.dao.*;
import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.model.*;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet( urlPatterns = {"/SearchServlet.do"})
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO accomDao = new JDBCPropertyDAOImpl();
		accomDao.setConnection(conn);
		
		List<Property> searchList = accomDao.getAllByCityName(request.getParameter("lugar-alojamiento"));
		
		if(searchList == null || searchList.isEmpty()) {
			request.setAttribute("messages", "No existe ningún alojamiento con los requisitos mencionados");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
			view.forward(request, response);
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/listaAlojamientos.jsp");
			request.setAttribute("ciudad", request.getParameter("lugar-alojamiento"));
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
