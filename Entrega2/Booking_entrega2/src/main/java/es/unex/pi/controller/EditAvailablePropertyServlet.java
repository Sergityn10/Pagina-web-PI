package es.unex.pi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.model.Property;
import es.unex.pi.model.User;

/**
 * Servlet implementation class EditAvailablePropertyServlet
 * 
 */
@WebServlet( urlPatterns = {"/properties/EditAvailablePropertyServlet.do"})
public class EditAvailablePropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAvailablePropertyServlet() {
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
		PropertyDAO propertyDao = new JDBCPropertyDAOImpl();
		propertyDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		long idp = Long.parseLong(request.getParameter("idp"));
		//TODO Descomentar cuando este implementando la función de iniciar sesión
		long idu = user.getId();
		
		Property property = propertyDao.get(idp);
		if(property.getAvailable() == 1)
			property.setAvailable(0);
		else
			property.setAvailable(1);
		
		
		propertyDao.update(property);
		response.sendRedirect("ListPropertiesServlet.do");
	}

}
