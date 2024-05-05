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

@Path("/categories")
public class CategoryResource {

	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	@GET
	@Path("/category/{categoryid:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Category getCategoryJSON(@PathParam("categoryid") long categoryid, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		CategoryDAO categoriaDao = new JDBCCategoryDAOImpl();
		categoriaDao.setConnection(conn);

		Category categoria = categoriaDao.get(categoryid);

		if (categoria != null) {
			return categoria;
		} else
			throw new CustomBadRequestException("No se ha encontrado la categoría");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAllCategoriesJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		CategoryDAO categoriaDao = new JDBCCategoryDAOImpl();
		categoriaDao.setConnection(conn);

		List<Category> listaCategorias;
		listaCategorias = categoriaDao.getAll();

		return listaCategorias;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCategory(Category categoria, @Context HttpServletRequest request) {
		Response res;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		CategoryDAO categoriaDao = new JDBCCategoryDAOImpl();
		categoriaDao.setConnection(conn);

		// Se comprueba que no haya una categoría ya existente con el mismo nombre
		Category categoriaAux = categoriaDao.get(categoria.getName());

		if (categoriaAux == null) {
			logger.info("Se añade la categoría a la BD");

			categoriaDao.add(categoria);
			Long idC = categoria.getId();

			res = Response.created(uriInfo.getAbsolutePathBuilder().path("category/" + idC).build())
					.contentLocation(uriInfo.getAbsolutePathBuilder().path("category/" + idC).build()).build();

			return res;
		}

		else
			throw new CustomBadRequestException("No se ha podido realizar la operacion");

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(Category editCategoria, @Context HttpServletRequest request) {
		Response res;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		CategoryDAO categoriaDao = new JDBCCategoryDAOImpl();
		categoriaDao.setConnection(conn);

		// Se comprueba si esxiste un alojamiento con ese id
		Long idC = editCategoria.getId();
		Category categoriaAux = categoriaDao.get(idC);

		if (categoriaAux != null) {
			// Sí que existe

			// Se pasa a comprobar que el nombre que se desea poner no esté ya en la BD
			categoriaAux = null;
			categoriaAux = categoriaDao.get(editCategoria.getName());

			if (categoriaAux == null) {
				if (categoriaDao.update(editCategoria)) {
					res = Response.created(uriInfo.getAbsolutePathBuilder().path("category/" + idC).build())
							.contentLocation(uriInfo.getAbsolutePathBuilder().path("category/" + idC).build()).build();

					return res;
				} else
					throw new CustomBadRequestException("No se ha podido realizar la operacion");
			} else
				throw new CustomBadRequestException("Ya existe una categoría con ese nombre");

		} else
			throw new CustomBadRequestException("No existe ninguna categoría con ese identificador");

	}
	
	@DELETE
	@Path("/category/{categoryid: [0-9]+}")
	public Response deleteCategory(@PathParam("categoryid") long categoryid, @Context HttpServletRequest request) {
		Response res;
		
		Connection conn = (Connection) sc.getAttribute("dbConn");

		CategoryDAO categoriaDao = new JDBCCategoryDAOImpl();
		categoriaDao.setConnection(conn);
		
		if (categoriaDao.delete(categoryid)) {
			logger.info("Eliminación realizada correctamente");
			res = Response.noContent().build();
			return res;
		} else throw new CustomBadRequestException("No se ha podido realizar la operacion");
		
	}
	
	

}
