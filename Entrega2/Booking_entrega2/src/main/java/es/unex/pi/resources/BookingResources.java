package es.unex.pi.resources;

import java.util.logging.Logger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import es.unex.pi.dao.*;
import es.unex.pi.model.*;
import es.unex.pi.resources.exceptions.CustomBadRequestException;
import es.unex.pi.resources.exceptions.CustomNotFoundException;

import java.sql.Connection;
import java.util.*;

@Path("/books")
public class BookingResources {
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName()); 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Booking> getBooksJSON(@Context HttpServletRequest request){
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingDAO bookDao = new JDBCBookingDAOImpl();
		bookDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if(user != null ) 
			return bookDao.getAllByIdUser(user.getId());
		else 
			throw new CustomBadRequestException("Debes iniciar sesión para poder añadir una habitacion a un alojamiento");

	}
	@GET
	@Path("/{idb: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Booking getBookJSON(@PathParam("idb") long idb,@Context HttpServletRequest request){
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingDAO bookDao = new JDBCBookingDAOImpl();
		bookDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if(user != null ) 
			if(bookDao.get(idb) != null)
				if(bookDao.get(idb).getIdu() == user.getId())
					return bookDao.get(idb);
				else throw new CustomBadRequestException("No puedes acceder a una reserva que no este tuya.");
			else throw new CustomNotFoundException("No se ha podido encontrar la reserva deseada");
		else 
			throw new CustomBadRequestException("Debes iniciar sesión para poder realizar una reserva a un alojamiento");

	}
	
	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<Booking>
	 * getAllBooksByIdpJSON(@Context HttpServletRequest request){ Connection conn =
	 * (Connection) sc.getAttribute("dbConn"); BookingDAO bookDao = new
	 * JDBCBookingDAOImpl(); bookDao.setConnection(conn);
	 * 
	 * HttpSession session = request.getSession(); User user = (User)
	 * session.getAttribute("user");
	 * 
	 * if(user != null ) return bookDao.getAll(user.getId()); else throw new
	 * CustomBadRequestException("Debes iniciar sesión para poder añadir una habitacion a un alojamiento"
	 * );
	 * 
	 * }
	 */


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postBookJSON(Booking book, @Context HttpServletRequest request) {
		
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingDAO bookDao = new JDBCBookingDAOImpl();
		bookDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		Response res = null;
		if(user != null ) 
			if(bookDao.get(book.getId()) != null)
				if(book.getIdu() == user.getId()) {
					bookDao.add(book);
					res = Response //return 201 and Location: /orders/newid
							   .created(
								uriInfo.getAbsolutePathBuilder()
									   .path(Long.toString(user.getId()))
									   .build())
							   .contentLocation(
								uriInfo.getAbsolutePathBuilder()
								       .path(Long.toString(book.getId()))
								       .build())
								.build();
					return res;
				}
				else throw new CustomBadRequestException("No puedes añadir una reserva a un usuario externo a ti");
			else throw new CustomNotFoundException("Esta reserva ya existe");
		else 
			throw new CustomBadRequestException("Debes iniciar sesión para poder añadir una habitacion a un alojamiento");
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putBookJSON(Booking book, @Context HttpServletRequest request) {
		
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingDAO bookDao = new JDBCBookingDAOImpl();
		bookDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		Response res = null;
		if(user != null ) 
			if(bookDao.get(book.getId()) == null)
				if(book.getIdu() == user.getId()) {
					bookDao.add(book);
					res = Response //return 201 and Location: /orders/newid
							   .created(
								uriInfo.getAbsolutePathBuilder()
									   .path(Long.toString(user.getId()))
									   .build())
							   .contentLocation(
								uriInfo.getAbsolutePathBuilder()
								       .path(Long.toString(book.getId()))
								       .build())
								.build();
					return res;
				}
				else throw new CustomBadRequestException("No puedes actualizar una reserva a un usuario externo a ti");
			else throw new CustomNotFoundException("Esta reserva no existe");
		else 
			throw new CustomBadRequestException("Debes iniciar sesión para poder añadir una habitacion a un alojamiento");
		
	}
	
	@DELETE
	@Path("{idb: [0-9]+}")
	public Response deleteBook(@PathParam("idb") long idb,@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingDAO bookDao = new JDBCBookingDAOImpl();
		bookDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		
		if(user != null) {
			if(bookDao.get(idb) != null) {
				if(bookDao.get(idb).getIdu() == user.getId()) {
					bookDao.delete(idb);
					return Response.noContent().build();
				}else throw new CustomBadRequestException("No puedes borrar una reserva que no sea tuya.");
					
			}else throw new CustomNotFoundException("Esta reserva no existe");
			
		}else throw new CustomBadRequestException("Debes iniciar sesión para poder realizar el borrado de todas tus reviews");
		



			
	}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteBook(Booking book,@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingDAO bookDao = new JDBCBookingDAOImpl();
		bookDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		
		if(user != null) {
			if(bookDao.get(book.getId()) != null) {
				if(bookDao.get(book.getId()).getIdu() == user.getId()) {
					bookDao.delete(book.getId());
					return Response.noContent().build();
				}else throw new CustomBadRequestException("No puedes borrar una reserva que no sea tuya.");
					
			}else throw new CustomNotFoundException("Esta reserva no existe");
			
		}else throw new CustomBadRequestException("Debes iniciar sesión para poder realizar el borrado de todas tus reviews");
		



			
	}
	
	
	
	
}
