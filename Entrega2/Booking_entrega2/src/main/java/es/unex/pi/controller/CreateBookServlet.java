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
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.model.User;
import es.unex.pi.model.Accommodation;
import es.unex.pi.model.Booking;
import es.unex.pi.model.BookingsAccommodations;
import es.unex.pi.model.Property;
import es.unex.pi.dao.JDBCBookingDAOImpl;
import es.unex.pi.dao.BookingDAO;


import es.unex.pi.dao.JDBCBookingsAccommodationsDAOImpl;
import es.unex.pi.dao.BookingsAccommodationsDAO;
import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.dao.AccommodationDAO;

/**
 * Servlet implementation class CreateBookServlet
 * 
 */

@WebServlet( urlPatterns = {"/books/CreateBookServlet.do"})
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		PropertyDAO propDao = new JDBCPropertyDAOImpl();
		propDao.setConnection(conn);
		
		BookingDAO bookingDao = new JDBCBookingDAOImpl();
		bookingDao.setConnection(conn);

		BookingsAccommodationsDAO bookingAccommodationsDao = new JDBCBookingsAccommodationsDAOImpl();
		bookingAccommodationsDao.setConnection(conn);
		
		AccommodationDAO accommodationDao = new JDBCAccommodationDAOImpl();
		accommodationDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Long idp = Long.parseLong(request.getParameter("idp"));
		Property prop = propDao.get(idp);
		
		List<Accommodation> accomList = accommodationDao.getAllBySearchIdp(idp);
		List<BookingsAccommodations> accomBookList = new ArrayList<BookingsAccommodations>();
		
		int price_total=0;
		for(Accommodation accom : accomList) {
			
			int num_accom=0;
			
				num_accom = Integer.parseInt(request.getParameter("accomN"+accom.getId()));
			
			int price_accom = num_accom*accom.getPrice();
			price_total=price_total+price_accom;
		}
		
		Booking book = new Booking ();
		book.setIdu(user.getId());
		book.setTotalPrice(price_total);
		
		bookingDao.add(book);
		List<Booking> booksUser = bookingDao.getAllByIdu(user.getId());
		book = bookingDao.get(booksUser.get(booksUser.size()-1).getId());
		
		for(Accommodation accom : accomList) {
			int num_accom = Integer.parseInt(request.getParameter("accomN"+accom.getId()));
			if(num_accom>0) {
				BookingsAccommodations accomBook = new BookingsAccommodations ();
				accomBook.setIdacc(accom.getId());
				accomBook.setIdb(book.getId());
				accomBook.setNumAccommodations(num_accom);
				bookingAccommodationsDao.add(accomBook);
				accomBookList.add(accomBook);
			}
			
		}
		request.setAttribute("accomBookList", accomBookList);
		response.sendRedirect("ListBookingsServlet.do");
		/*RequestDispatcher view = request.getRequestDispatcher("ListBookings.jsp");
		view.forward(request, response);*/
		
	}

}
