package es.unex.pi.resources;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.*;
import es.unex.pi.model.*;
import es.unex.pi.resources.exceptions.*;
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

@Path("/users")
public class UserResource {

	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;

	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	// Hace falta????
	@GET
	@Path("/user/actual")
	@Produces(MediaType.APPLICATION_JSON)
	public User getSessionUserJSON(@Context HttpServletRequest request) {

		// Se obtiene el usuario de la sesión
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		return user;
	}

	@GET
	@Path("/user/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public User logoutUserJSON(@Context HttpServletRequest request) {

		// Se elimina el usuario de la sesión
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			session.removeAttribute("user");
			logger.info("Se ha eliminado el usuario de la sesión");
		}

		// Si se retorna null quiere decir que no se ha borrado ningún usuario de la
		// sesión
		return user;
	}

	@GET
	@Path("/user/{userid:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserJSON(@PathParam("userid") long userid, @Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");

		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);

		User user = userDao.get(userid);

		if (user != null) {
			return user;
		} else {
			throw new CustomBadRequestException("User not yet created");
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsersJSON(@Context HttpServletRequest request) {
		List<User> listaUsuarios;
		Connection conn = (Connection) sc.getAttribute("dbConn");

		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);

		listaUsuarios = userDao.getAll();

		return listaUsuarios;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUserJSON(User user, @Context HttpServletRequest request) {
		Response res = null;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);

		// Se comprueba si ya hay un usuario con ese email
		String email = user.getEmail();

		User userAux = userDao.getByEmail(email);
		if (userAux == null) {
			logger.info("createUser -> No hay coincidencia de email, se añade a la BD");

			userDao.add(user);

			res = Response.noContent().build();
			return res;

		} else
			throw new CustomBadRequestException("El correo electrónico ya se encuentra en uso");

	}


	@GET
	@Path("/user/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginUserJSON(User user, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);

		// Se comprueba si existe un usuario con ese email y contraseña
		String email = user.getEmail();
		String contraseña = user.getPassword();

		User userAux = userDao.getByEmailPassword(email, contraseña);
		if (userAux != null) {
			// Existe el usuario, se añade a la sesión
			HttpSession session = request.getSession();
			session.setAttribute("user", userAux);
			
			long idU = userAux.getId();
			
			Response res = Response 		
			.created(
				uriInfo.getAbsolutePathBuilder()
				   .path("/user/"+idU)
				   .build())
					.contentLocation(					
				uriInfo.getAbsolutePathBuilder()
			       .path("/user/"+idU)
			       .build())
			.build();
			
			return res;

		}else throw new CustomBadRequestException("El usuario o contraseña con incorrectos");
	
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUserJSON(User editUser, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User userActual = (User) session.getAttribute("user");
		
		if (userActual.getId() == editUser.getId()) {
			if (userDao.update(editUser)) {
				Response res = Response.noContent().build();
				return res;
				
			} else throw new CustomBadRequestException("Error en la actualización de usuario");
			
		} else throw new CustomBadRequestException("Error: Se está intentando modificar un usuario distinto al de la sesión");
		
	}	
	
	
	@DELETE
	public Response deleteUserJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		UserDAO userDAO = new JDBCUserDAOImpl();
		userDAO.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Long userId = user.getId();
		
		//Se elimina el usuario de la BD
		if (userDAO.delete(userId)) {
			logger.info("Eliminación de usuario correcta");
			
			//También se elimina el usuario de la sesión
			session.removeAttribute("user");
			
			Response res = Response.noContent().build();
			return res;
			
		} else throw new CustomBadRequestException("No se ha podido eliminar el usuario");
		
	}

}

























