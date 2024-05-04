package es.unex.pi.resources;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCPropertyUserDAOImpl;
import es.unex.pi.dao.JDBCReviewDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.PropertyUserDAO;
import es.unex.pi.dao.ReviewDAO;
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
	  public List<propertyUser> getPropsUsersJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		PropertyUserDAO propUserDao = new JDBCPropertyUserDAOImpl();
		propUserDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<propertyUser> propUsers;
		if(user != null)
			propUsers = propUserDao.getAllByUser(user.getId());
		else throw new CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");

		return propUsers; 
	  }



	  //FUNCIONA LA OPERACION POST CON JSON





	  @POST
	  @Path("/{propid: [0-9]+}")
	  public Response postPropertyUsers(@PathParam("propid")long idp,
			  @Context HttpServletRequest request) {
		  Connection conn = (Connection) sc.getAttribute("dbConn");
		  PropertyUserDAO propUserDao = new JDBCPropertyUserDAOImpl();
		  propUserDao.setConnection(conn);

		  HttpSession session = request.getSession();
		  User user = (User) session.getAttribute("user");
		  if(user != null) {
			  propertyUser itPropUser = new propertyUser();
			  itPropUser.setIdp(idp);
			  itPropUser.setIdu(user.getId());

			  Response res = null;

			  if(propUserDao.get(itPropUser.getIdp(), itPropUser.getIdu()) == null) {
				  propUserDao.add(itPropUser);
				  logger.info("POST de la review: idp->" + itPropUser.getIdp()+ ", idu->" + itPropUser.getIdu());
				  res = Response //return 201 and Location: /orders/newid
						  .created(
								  uriInfo.getAbsolutePathBuilder()
								  .path(Long.toString(user.getId()))
								  .build())
						  .contentLocation(
								  uriInfo.getAbsolutePathBuilder()
								  .path(Long.toString(idp))
								  .build())
						  .build();
				  return res;
			  }
			  else throw new CustomBadRequestException("Ya habias añadido este alojamiento a favoritos");
		  }
		  else throw new CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");
			
		  
	  }
	  

	 
	  @DELETE
	  @Path("/{propid: [0-9]+}")	  
	  public Response deletePropUser(@PathParam("propid") long idp,
			  					  @Context HttpServletRequest request) {
		  
		  Connection conn = (Connection) sc.getAttribute("dbConn");
		  PropertyUserDAO propUserDao = new JDBCPropertyUserDAOImpl();
		  propUserDao.setConnection(conn);

		  HttpSession session = request.getSession();
		  User user = (User) session.getAttribute("user");
		  if(user != null) {
			  propertyUser itPropUser = new propertyUser();
			  itPropUser.setIdp(idp);
			  itPropUser.setIdu(user.getId());

			  Response res = null;

			  if(propUserDao.get(itPropUser.getIdp(), itPropUser.getIdu()) != null) {
				  propUserDao.delete(idp, user.getId());
				  logger.info("POST de la review: idp->" + itPropUser.getIdp()+ ", idu->" + itPropUser.getIdu());
				  res = Response //return 201 and Location: /orders/newid
						  .created(
								  uriInfo.getAbsolutePathBuilder()
								  .path(Long.toString(user.getId()))
								  .build())
						  .contentLocation(
								  uriInfo.getAbsolutePathBuilder()
								  .path(Long.toString(idp))
								  .build())
						  .build();
				  return res;
			  }
			  else throw new CustomBadRequestException("Ya existe una review por este usuario");
		  }
		  else throw new CustomBadRequestException("Tienes que iniciar sesión para poder acceder a este recurso: GET PropertyUser");
					
	  }
	  
	
}
