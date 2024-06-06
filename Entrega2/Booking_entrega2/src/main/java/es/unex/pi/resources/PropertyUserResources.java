package es.unex.pi.resources;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCPropertyUserDAOImpl;
import es.unex.pi.dao.JDBCReviewDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.PropertyUserDAO;
import es.unex.pi.dao.ReviewDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Review;
import es.unex.pi.model.*;
import es.unex.pi.resources.exceptions.CustomBadRequestException;
import es.unex.pi.resources.exceptions.CustomNotFoundException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
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

@Path("/favorites")
public class PropertyUserResources {
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user/{idu: [0-9]+}")
	public List<propertyUser> getPropsUsersJSON(@PathParam("idu")long idu,@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		PropertyUserDAO propUserDao = new JDBCPropertyUserDAOImpl();
		propUserDao.setConnection(conn);

		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		User user = userDao.get(idu);
		List<propertyUser> propUsers;
		if (user != null)
			return propUserDao.getAllByUser(user.getId());
		else
			throw new CustomBadRequestException(
					"Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");

		
	}

	// FUNCIONA LA OPERACION POST CON JSON

	@POST
	@Path("/user/{idu: [0-9]+}/prop/{propid: [0-9]+}")
	public Response postPropertyUsers(@PathParam("idu") long idu,@PathParam("propid") long idp, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		PropertyUserDAO propUserDao = new JDBCPropertyUserDAOImpl();
		propUserDao.setConnection(conn);
		
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		User user = userDao.get(idu);

		
		if (user != null) {
			propertyUser itPropUser = new propertyUser();
			itPropUser.setIdp(idp);
			itPropUser.setIdu(user.getId());

			Response res = null;

			if (propUserDao.get(itPropUser.getIdp(), itPropUser.getIdu()) == null) {
				propUserDao.add(itPropUser);
				logger.info("POST de la review: idp->" + itPropUser.getIdp() + ", idu->" + itPropUser.getIdu());
				res = Response // return 201 and Location: /orders/newid
						.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(user.getId())).build())
						.contentLocation(uriInfo.getAbsolutePathBuilder().path(Long.toString(idp)).build()).build();
				return res;
			} else
				throw new CustomBadRequestException("Ya habias añadido este alojamiento a favoritos");
		} else
			throw new CustomBadRequestException(
					"Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");

	}

	@DELETE
	@Path("/user/{idu: [0-9]+}/prop/{propid: [0-9]+}")
	public Response deletePropUser(@PathParam("idu") long idu,@PathParam("propid") long idp, @Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		PropertyUserDAO propUserDao = new JDBCPropertyUserDAOImpl();
		propUserDao.setConnection(conn);
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		HttpSession session = request.getSession();
		User user = userDao.get(idu);
		if (user != null) {
			propertyUser itPropUser = new propertyUser();
			itPropUser.setIdp(idp);
			itPropUser.setIdu(user.getId());

			Response res = null;

			if (propUserDao.get(idp, idu) != null) {
				propUserDao.delete(idp, user.getId());
				logger.info("DELETE de la review: idp->" + itPropUser.getIdp() + ", idu->" + itPropUser.getIdu());
				res = Response // return 201 and Location: /orders/newid
						.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(user.getId())).build())
						.contentLocation(uriInfo.getAbsolutePathBuilder().path(Long.toString(idp)).build()).build();
				return res;
			} else
				throw new CustomBadRequestException("No existe una review por este usuario");
		} else
			throw new CustomBadRequestException(
					"Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");

	}

}
