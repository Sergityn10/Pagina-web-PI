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

@Path("/properties")
public class PropertyResource {
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	@GET
	@Path("/{propertyid:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Property getPropertyJSON(@PathParam("propertyid") long propertyid, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		Property alojamiento = alojamientoDao.get(propertyid);

		if (alojamiento != null) {
			return alojamiento;
		} else
			throw new CustomBadRequestException("No se ha encontrado el alojamiento");

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Property> getAllPropertiesJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		List<Property> listaAlojamientos;
		listaAlojamientos = alojamientoDao.getAll();

		return listaAlojamientos;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public List<Property> getAllPropertiesByUSerJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		// Se recupera el usuario de la sesión
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Long idU = user.getId();

		List<Property> listaAlojamientos;
		listaAlojamientos = alojamientoDao.getAllByUser(idU);

		return listaAlojamientos;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProperty(Property alojamiento, @Context HttpServletRequest request) {
		Response res;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		// Se obtiene el identificador de usuario
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Long idu = user.getId();

		if (alojamiento.getIdu() == idu) {
			// Coincide el usuario que va a añadir el alojamiento con el que se encuentra en
			// la sesión
			logger.info("Se añade el alojamiento a la BD");

			Long id = alojamientoDao.add(alojamiento);
			res = Response.created(uriInfo.getAbsolutePathBuilder().path("property/" + Long.toString(id)).build())
					.contentLocation(uriInfo.getAbsolutePathBuilder().path("property/" + Long.toString(id)).build())
					.build();
			return res;

		} else
			throw new CustomBadRequestException("No se ha podido realizar la operacion");

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProperty(Property editAlojamiento, @Context HttpServletRequest request) {
		Response res;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		// Se comprueba si esxiste un alojamiento con ese id
		Long idA = editAlojamiento.getId();
		Property alojamientoAux = alojamientoDao.get(idA);

		if (alojamientoAux != null) {
			// Sí que existe, se realizan los cambios
			if (alojamientoDao.update(editAlojamiento)) {
				res = Response.created(uriInfo.getAbsolutePathBuilder().path("property/" + idA).build())
						.contentLocation(uriInfo.getAbsolutePathBuilder().path("property/" + idA).build()).build();
			
				return res;
			} else
				throw new CustomBadRequestException("No se ha podido realizar la operacion");
		} else
			throw new CustomBadRequestException("No existe ningún alojamiento con ese identificador");

	}
	
	@DELETE
	@Path("/property/{propertyid: [0-9]+}")
	public Response deleteProperty(@PathParam("propertyid") long propertyid, @Context HttpServletRequest request) {
		Response res;
		
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);
		
		if (alojamientoDao.delete(propertyid)) {
			logger.info("Eliminación realizada correctamente");
			res = Response.noContent().build();
			return res;
		} else throw new CustomBadRequestException("No se ha podido realizar la operacion");
		
	}
	
}








