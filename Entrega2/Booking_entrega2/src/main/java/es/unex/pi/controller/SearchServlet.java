package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.KeyPair;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.logging.Logger;

import org.apache.tomcat.jakartaee.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm;

import es.unex.pi.dao.*;
import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.model.*;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet( urlPatterns = {"/SearchServlet.do"})
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO propDao = new JDBCPropertyDAOImpl();
		propDao.setConnection(conn);
		
		
		
		List<Property> searchList = propDao.getAllByCityName(request.getParameter("lugar-alojamiento"));
		List<Property> searchListName = propDao.getAllBySearchName(request.getParameter("lugar-alojamiento"));
		
	
		
		for(Property alojamiento : searchListName) { //función para 
			if(!searchList.contains(alojamiento)){
				searchList.add(alojamiento);
			}
			
				
		}
		
		
		
		
		String disponibilidad = request.getParameter("disponibilidad");
		
		logger.info("Valor del parametro disponiblidad: "+ disponibilidad);
		
		if(searchList == null || searchList.isEmpty()) {
			request.setAttribute("messages", "No existe ningún alojamiento con los requisitos mencionados");
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
			view.forward(request, response);
		}
		else {
			AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
			accomDao.setConnection(conn);
			
			
		
			HashMap<Property,List<Accommodation>> propAccomList = new HashMap<Property, List<Accommodation>>();
			//Triplet <Property, List<Accommodation>, Boolean> p ;
			
			if(disponibilidad.equals("todos")) {
				
				for(Property itProperty : searchList) {
					
					List<Accommodation> listAccom = accomDao.getAllBySearchIdp(itProperty.getId());
					propAccomList.put(itProperty, listAccom);
				}
			}
			else {
				if(disponibilidad.equals("con_disp")) {
					for(Property itProperty : searchList) {
						if(itProperty.getAvailable()==1) {
							List<Accommodation> listAccom = accomDao.getAllBySearchIdp(itProperty.getId());
							propAccomList.put(itProperty, listAccom);
						}
					}
				}
				else {
					for(Property itProperty : searchList) {
						if(itProperty.getAvailable()==0) {
							List<Accommodation> listAccom = accomDao.getAllBySearchIdp(itProperty.getId());
							propAccomList.put(itProperty, listAccom);
						}
					}
				}
			}
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/listaAlojamientos.jsp");
			
			request.setAttribute("listaAlojamientos", propAccomList);
			request.setAttribute("ciudad", request.getParameter("lugar-alojamiento"));
			request.setAttribute("disp", disponibilidad);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
