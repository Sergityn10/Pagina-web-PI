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

@Path("/propertiesCategories")
public class PropertyCategoryResource {
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	@GET
	@Path("/property/{propertyid:[0-9]+}/category/{categoryid:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public PropertiesCategories getPropertyCategoryJSON(@PathParam("propertyid") long propertyid,
			@PathParam("categoryid") long categoryid, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertiesCategoriesDAO propCategDao = new JDBCPropertiesCategoriesDAOImpl();
		propCategDao.setConnection(conn);

		PropertiesCategories propertyCategory = propCategDao.get(propertyid, categoryid);

		if (propertyCategory != null) {
			return propertyCategory;
		} else
			throw new CustomBadRequestException("No se ha encontrado la categoría");

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PropertiesCategories> getAllPropertiesCategoriesJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertiesCategoriesDAO propCategDao = new JDBCPropertiesCategoriesDAOImpl();
		propCategDao.setConnection(conn);

		List<PropertiesCategories> listaPC;
		listaPC = propCategDao.getAll();

		return listaPC;
	}

	@GET
	@Path("/category/{categoryid:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PropertiesCategories> getAllByCategoryPropertiesCategoriesJSON(@PathParam("categoryid") long categoryid,
			@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertiesCategoriesDAO propCategDao = new JDBCPropertiesCategoriesDAOImpl();
		propCategDao.setConnection(conn);

		List<PropertiesCategories> listaPC;
		listaPC = propCategDao.getAllByCategory(categoryid);

		return listaPC;
	}

	@GET
	@Path("/property/{propertyid:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PropertiesCategories> getAllByPropertyPropertiesCategoriesJSON(@PathParam("propertyid") long propertyid,
			@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertiesCategoriesDAO propCategDao = new JDBCPropertiesCategoriesDAOImpl();
		propCategDao.setConnection(conn);

		List<PropertiesCategories> listaPC;
		listaPC = propCategDao.getAllByProperty(propertyid);

		return listaPC;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPropertyCategory(PropertiesCategories propertyCategory, @Context HttpServletRequest request) {
		Response res;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertiesCategoriesDAO propCategDao = new JDBCPropertiesCategoriesDAOImpl();
		propCategDao.setConnection(conn);

		// Se comprueba que no exista esa relación propiedad-categoria
		Long idP = propertyCategory.getIdp();
		Long idC = propertyCategory.getIdct();

		PropertiesCategories pcAux = propCategDao.get(idP, idC);

		if (pcAux == null) {
			logger.info("Se añade a la BD");

			propCategDao.add(propertyCategory);

			res = Response
					.created(uriInfo.getAbsolutePathBuilder().path("property/").path(Long.toString(idP))
							.path("/category/").path(Long.toString(idC)).build())
					.contentLocation(uriInfo.getAbsolutePathBuilder().path("property/").path(Long.toString(idP))
							.path("/category/").path(Long.toString(idC)).build())
					.build();

			return res;

		} else
			throw new CustomBadRequestException("No se ha podido realizar la operacion");

	}

	// @PUT
	// Se ha considerado que no se puede editar. Puesto que todos los atributos
	// forman parte de la PK
	// Editar sería lo mismo que eliminar y luego crear

	@DELETE
	@Path("/property/{propertyid:[0-9]+}/category/{categoryid:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePropertyCategoryJSON(@PathParam("propertyid") long propertyid,
			@PathParam("categoryid") long categoryid, @Context HttpServletRequest request) {
		Response res;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertiesCategoriesDAO propCategDao = new JDBCPropertiesCategoriesDAOImpl();
		propCategDao.setConnection(conn);

		if (propCategDao.delete(propertyid, categoryid)) {
			logger.info("Eliminación realizada correctamente");
			res = Response.noContent().build();
			return res;
		} else
			throw new CustomBadRequestException("No se ha podido realizar la operacion");

	}

}
