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
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.apache.tomcat.jakartaee.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm;

import es.unex.pi.dao.*;
import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.model.*;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(urlPatterns = { "/SearchServlet.do" })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("SearchServlet GET");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO propDao = new JDBCPropertyDAOImpl();
		propDao.setConnection(conn);

		String valoracion = request.getParameter("valoracion");

		List<Property> searchList;
		List<Property> searchListName;

		if (valoracion == null) {
			logger.info("SearchServlet GET: No se ordena por valoración");
			searchList = propDao.getAllByCityName(request.getParameter("lugar-alojamiento"));
			searchListName = propDao.getAllBySearchName(request.getParameter("lugar-alojamiento"));
		} else {
			// En caso de que esté marcado el campo de ordenar por valoración, se ordena por
			// la misma
			logger.info("SearchServlet GET: Se ordena por valoración");
			searchList = propDao.getAllByCityNameValDesc(request.getParameter("lugar-alojamiento"));
			searchListName = propDao.getAllBySearchNameValDesc(request.getParameter("lugar-alojamiento"));

		}

		logger.info("Lista Name");
		for (Property property : searchListName) {
			logger.info("Alojamiento: " + property.getName());
		}

		logger.info("Lista City");
		for (Property property : searchList) {
			logger.info("Alojamiento: " + property.getName());
		}

		for (Property alojamiento : searchListName) { // Realiza la unión de los alojamientos con los requisitos de
														// búsqueda
			if (!searchList.contains(alojamiento)) {
				searchList.add(alojamiento);
			}
		}

		logger.info("Lista final");
		for (Property property : searchList) {
			logger.info("Alojamiento: " + property.getName());
		}

		String disponibilidad = request.getParameter("disponibilidad");

		logger.info("Valor del parametro disponiblidad: " + disponibilidad);

		if (searchList == null || searchList.isEmpty()) {
			request.setAttribute("messages", "No existe ningún alojamiento con los requisitos mencionados");

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
			view.forward(request, response);
		} else {
			// Se han encontrado resultados
			AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
			accomDao.setConnection(conn);
			List<Property> searchAux = new ArrayList<Property>();
			// Se aplica el filtro de disponibilidad
			if (!disponibilidad.equals("todos")) {
				logger.info("DISPONIBILIDAD DISTINTO DE TODOS");
				if (disponibilidad.equals("con_disp")) {
					for (Property itProperty : searchList) {
						if (itProperty.getAvailable() == 1) {
							searchAux.add(itProperty);
						}
					}
				} else {
					for (Property itProperty : searchList) {
						if (itProperty.getAvailable() == 0) {
							searchAux.add(itProperty);
						}
					}
				}
			}
				request.setAttribute("listaAlojamientos", searchAux);	
				request.setAttribute("ciudad", request.getParameter("lugar-alojamiento"));
				request.setAttribute("disp", disponibilidad);
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/listaAlojamientos.jsp");

				
				view.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("SearchServlet GET");
		doGet(request, response);
	}

}
