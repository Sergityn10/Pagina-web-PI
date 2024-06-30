package es.unex.pi.resources;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.JDBCBookingsAccommodationsDAOImpl;
import es.unex.pi.dao.JDBCPropertyUserDAOImpl;
import es.unex.pi.dao.PropertyUserDAO;
import es.unex.pi.dao.BookingsAccommodationsDAO;
import es.unex.pi.model.User;
import es.unex.pi.model.propertyUser;
import es.unex.pi.model.BookingsAccommodations;
import es.unex.pi.resources.exceptions.CustomBadRequestException;
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

@Path("/booksAccoms")
public class BookingAccommodationsResources {
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName()); 


	@GET
	@Path("/book/{idb: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookingsAccommodations> getBooksAccomsByIdbJSON(@PathParam("idb") long idb,@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingsAccommodationsDAO booksAccomsDao = new JDBCBookingsAccommodationsDAOImpl();
		booksAccomsDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<BookingsAccommodations> booksAccoms;
		//if(user != null)
			booksAccoms = booksAccomsDao.getAllByBooking(idb);
		//else throw new CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");

		return booksAccoms; 
	}

	@GET
	@Path("/accom/{idacc: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookingsAccommodations> getBooksAccomsByIdAccJSON(@PathParam("idacc") long idacc,@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingsAccommodationsDAO booksAccomsDao = new JDBCBookingsAccommodationsDAOImpl();
		booksAccomsDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<BookingsAccommodations> booksAccoms;
		if(user != null)
			booksAccoms = booksAccomsDao.getAllByAccommodation(idacc);

		else throw new CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");

		return booksAccoms; 
	}

	/*
	 * @GET
	 * 
	 * @Path("/book/{idb: [0-9]+}/accom/{idacc: [0-9]+}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public List<BookingsAccommodations>
	 * getBooksAccomsJSON(@PathParam("idb") long idb,@PathParam("idacc") long
	 * idacc,@Context HttpServletRequest request) { Connection conn = (Connection)
	 * sc.getAttribute("dbConn"); BookingsAccommodationsDAO booksAccomsDao = new
	 * JDBCBookingsAccommodationsDAOImpl(); booksAccomsDao.setConnection(conn);
	 * 
	 * HttpSession session = request.getSession(); User user = (User)
	 * session.getAttribute("user"); List<BookingsAccommodations> booksAccoms;
	 * if(user != null) booksAccoms = booksAccomsDao.get(idacc);
	 * 
	 * else throw new
	 * CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser"
	 * );
	 * 
	 * return booksAccoms; }
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postBookinAccommodation(BookingsAccommodations newBookAccom,
			@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingsAccommodationsDAO booksAccomsDao = new JDBCBookingsAccommodationsDAOImpl();
		booksAccomsDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//if(user != null) {


			Response res = null;

			if(booksAccomsDao.get(newBookAccom.getIdb(), newBookAccom.getIdacc()) == null) {
				booksAccomsDao.add(newBookAccom);
				logger.info("POST de BookAccoms: idb->" + newBookAccom.getIdb()+ ", idacc->" + newBookAccom.getIdacc());
				res = Response //return 201 and Location: /orders/newid
						.created(
								uriInfo.getAbsolutePathBuilder()
								.path(Long.toString(newBookAccom.getIdb()))
								.build())
						.contentLocation(
								uriInfo.getAbsolutePathBuilder()
								.path(Long.toString(newBookAccom.getIdacc()))
								.build())
						.build();
				return res;
			}
			else throw new CustomBadRequestException("Ya existe una reserva con esta habitacion. Llama al PUT si la quieres actualizar");
		//}
		//else throw new CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");


	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putBookinAccommodation(BookingsAccommodations newBookAccom,
			@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingsAccommodationsDAO booksAccomsDao = new JDBCBookingsAccommodationsDAOImpl();
		booksAccomsDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null) {


			Response res = null;

			if(booksAccomsDao.get(newBookAccom.getIdb(), newBookAccom.getIdacc()) != null) {
				booksAccomsDao.update(booksAccomsDao.get(newBookAccom.getIdb(), newBookAccom.getIdacc()), newBookAccom);
				logger.info("PUT de BookAccoms: idb->" + newBookAccom.getIdb()+ ", idacc->" + newBookAccom.getIdacc());
				res = Response //return 201 and Location: /orders/newid
						.created(
								uriInfo.getAbsolutePathBuilder()
								.path(Long.toString(newBookAccom.getIdb()))
								.build())
						.contentLocation(
								uriInfo.getAbsolutePathBuilder()
								.path(Long.toString(newBookAccom.getIdacc()))
								.build())
						.build();
				return res;
			}
			else throw new CustomBadRequestException("No existe una reserva con esta habitacion. Llama al POST si lo quieres añadir");
		}
		else throw new CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");


	}

	@DELETE
	@Path("/book/{idb: [0-9]+}/accom/{idacc: [0-9]+}")	  
	public Response deletePropUser(@PathParam("idb") long idb,
			@PathParam("idacc")long idacc,
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		BookingsAccommodationsDAO booksAccomsDao = new JDBCBookingsAccommodationsDAOImpl();
		booksAccomsDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null) {


			Response res = null;

			if(booksAccomsDao.get(idb, idacc) != null) {
				booksAccomsDao.delete(idb,idacc);
				res = Response //return 201 and Location: /orders/newid
						.created(
								uriInfo.getAbsolutePathBuilder()
								.path("book/"+Long.toString(idb))
								.build())
						.contentLocation(
								uriInfo.getAbsolutePathBuilder()
								.path("accom/"+Long.toString(idacc))
								.build())
						.build();
				return res;
			}
			else throw new CustomBadRequestException("No existe una reserva con estas especificaciones");
		}
		else throw new CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: DELETE BookingAccommodation");

	}


}
