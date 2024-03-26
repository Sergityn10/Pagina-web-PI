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
import java.util.logging.Logger;

import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCReviewDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.ReviewDAO;
import es.unex.pi.model.Property;
import es.unex.pi.model.Review;

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
		
		
		
		Long id = Long.parseLong(request.getParameter("id"));
		Property prop = propDao.get(id);
		request.setAttribute("prop", prop); //Guardamos en la request la propiedad a la que se está accediendo y la que se quiere mostrar 
		
		List<Review> accomList=reviewDao.getAllByProperty(id);
		request.setAttribute("reviewList", accomList); //Guardamos en la request la lista de review que tiene el alojamiento buscado por el usuario
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/detalleAlojamiento.jsp");
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

