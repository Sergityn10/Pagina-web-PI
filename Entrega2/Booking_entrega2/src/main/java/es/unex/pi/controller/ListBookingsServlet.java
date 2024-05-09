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
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCBookingsAccommodationsDAOImpl;
import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.dao.JDBCBookingDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.BookingDAO;
import es.unex.pi.dao.BookingsAccommodationsDAO;
import es.unex.pi.dao.AccommodationDAO;
import es.unex.pi.model.Property;
import es.unex.pi.model.User;
import es.unex.pi.model.Booking;
import es.unex.pi.model.BookingsAccommodations;
import es.unex.pi.model.Accommodation;




/**
 * Servlet implementation class ListBookingsServlet
 * 
 */
@WebServlet( urlPatterns = {"/books/ListBookingsServlet.do"})
public class ListBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(JDBCBookingsAccommodationsDAOImpl.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBookingsServlet() {
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
		
		BookingDAO bookDao = new JDBCBookingDAOImpl();
		bookDao.setConnection(conn);
		
		BookingsAccommodationsDAO bookAccomDao = new JDBCBookingsAccommodationsDAOImpl();
		bookAccomDao.setConnection(conn);
		
		AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
		accomDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//TODO Descomentar cuando este implementado la funcionalidad de iniciar sesión
		//List<Booking> listBookings = bookDao.getAllByIdu(user.getId());
		List<Booking> listBookings = bookDao.getAll();
		//HashMap<Property,HashMap<Booking,List<BookingsAccommodations>>> propBookingList = new HashMap<Property, HashMap<Booking,List<BookingsAccommodations>>>();
		
		HashMap<Property, Booking> propBookingList = new HashMap <Property, Booking>();
		for(Booking book:listBookings) {
			if(user.getId()== book.getIdu()) {
				List<BookingsAccommodations> listAccom = bookAccomDao.getAllByBooking(book.getId());
				
				//Property prop = propDao.getByBooking(book, user.getId());
				Property prop = propDao.get(accomDao.get(listAccom.get(0).getIdacc()).getIdp());
				logger.info("TAMAÑÓ DE LA LISTA DE ACCOMMODATIONS DE LA RESERVA CON ID = "+ book.getId()+"->"+ listAccom.size());
				
				propBookingList.put(prop, book);
			}
		}
		
		request.setAttribute("listPropBooking", propBookingList);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/User/ListBookings.jsp");
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
