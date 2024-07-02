package es.unex.pi.resources;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.*;
import es.unex.pi.model.*;
import es.unex.pi.resources.exceptions.*;
import jakarta.servlet.RequestDispatcher;
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
	@Path("/disponibilidad/{disp:[0-1]}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Property> getAllPropertyByDisponibilidadJSON(@PathParam("disp") int disp, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		List<Property> alojamientos = alojamientoDao.getAllByDisp(disp);

		if (alojamientos != null) {
			return alojamientos;
		} else
			throw new CustomBadRequestException("No se ha encontrado el alojamiento");

	}
	
	@GET
  	@Path("/user/{idu: [0-9]+}")
  	public int getNumAccommodationsByIdu(@PathParam("idu") long idu, @Context HttpServletRequest request) {
  		int contador = 0;
  		
  		Connection conn = (Connection) sc.getAttribute("dbConn");
  		
  		//Primero hay que obtener los alojamientos del usuario
  		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
  		alojamientoDao.setConnection(conn);
  		
  		List<Property> listaAlojamientos = alojamientoDao.getAllByUser(idu);
  		
  		List<Accommodation> listaHabitaciones;
  		
  		for (Property alojamiento : listaAlojamientos) {
			
  			//Se obtiene el id del alojamiento
  			long idp = alojamiento.getId();
  			
  			//Se obtiene las habitaciones de ese alojamiento
  			AccommodationDAO habitacionDao = new JDBCAccommodationDAOImpl();
  			habitacionDao.setConnection(conn);
  			
  			listaHabitaciones = habitacionDao.getAllBySearchIdp(idp);
  			
  			contador = contador + listaHabitaciones.size();
  			
		}
  		
  		return contador;
  	}

	// Por el nombre, ya sea de Ciudad o del Alojamiento
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search")
	public List<Property> getPropertyBusquedaJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		String valoracion = request.getParameter("valoracion");

		List<Property> searchList;
		List<Property> searchListName;

		if (valoracion == null) {
			logger.info("No se ordena por valoración");
			searchList = alojamientoDao.getAllByCityName(request.getParameter("lugar-alojamiento"));
			searchListName = alojamientoDao.getAllBySearchName(request.getParameter("lugar-alojamiento"));
		} else {
			logger.info("Se ordena por valoración");
			searchList = alojamientoDao.getAllByCityNameValDesc(request.getParameter("lugar-alojamiento"));
			searchListName = alojamientoDao.getAllBySearchNameValDesc(request.getParameter("lugar-alojamiento"));
		}

		for (Property alojamiento : searchListName) {
			// Realiza la unión de los alojamientos con los requisitos debúsqueda
			if (!searchList.contains(alojamiento)) {
				searchList.add(alojamiento);
			}
		}

		String disponibilidad = request.getParameter("disponibilidad");

		List<Property> searchAux = new ArrayList<Property>();

		if (searchList != null || !searchList.isEmpty()) {
			// Se han encontrado resultados
			AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
			accomDao.setConnection(conn);

			// Se aplica el filtro de disponibilidad
			if (!disponibilidad.equals("todos")) {
				logger.info("DISPONIBILIDAD DISTINTO DE TODOS");

				if (disponibilidad.equals("con_disp")) {
					for (Property itProperty : searchList) {
						if (itProperty.getAvailable() == 1) {
							searchAux.add(itProperty);
						}
					}
				} else {
					for (Property itProperty : searchList) {
						if (itProperty.getAvailable() == 0) {
							searchAux.add(itProperty);
						}
					}
				}
			} else {
				searchAux = searchList;
			}
		}

		if (searchAux != null) {
			return searchAux;
		} else
			throw new CustomBadRequestException("No se han encontrado alojamientos");

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
	@Path("/user/{userid:[0-9]+}")
	public List<Property> getAllPropertiesByUSerJSON(@PathParam("userid") long userid,
			@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		List<Property> listaAlojamientos;
		listaAlojamientos = alojamientoDao.getAllByUser(userid);

		if (listaAlojamientos != null) {
			return listaAlojamientos;
		}

		else
			throw new CustomBadRequestException("No se han encontrado alojamientos del usuario "+ userid);
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProperty(Property alojamiento, @Context HttpServletRequest request) throws java.lang.Exception {
		Response res;
		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		// Se obtiene el identificador de usuario
		HttpSession session = request.getSession();
//		TODO User user = (User) session.getAttribute("user");
//
//		Long idu = user.getId();

//		if (alojamiento.getIdu() == idu) {
		if(true) {
			// Coincide el usuario que va a añadir el alojamiento con el que se encuentra en
			// la sesión
			logger.info("Se añade el alojamiento a la BD");

			Long id = alojamientoDao.add(alojamiento);
			res = Response.created(uriInfo.getAbsolutePathBuilder().path("property/" + Long.toString(id)).build())
					.contentLocation(uriInfo.getAbsolutePathBuilder().path("property/" + Long.toString(id)).build())
					.build();
			return res;

		} else {
			throw new Exception("No se ha podido realizar la operacion");
		}

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
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/disp")
	public Response changeDisponibilityProperty(Property editAlojamiento, @Context HttpServletRequest request) {
		Response res;

		Connection conn = (Connection) sc.getAttribute("dbConn");

		PropertyDAO alojamientoDao = new JDBCPropertyDAOImpl();
		alojamientoDao.setConnection(conn);

		// Se comprueba si esxiste un alojamiento con ese id
		Long idA = editAlojamiento.getId();
		Property alojamientoAux = alojamientoDao.get(idA);

		if (alojamientoAux != null) {
			// Sí que existe, se realizan los cambios
			if(editAlojamiento.getAvailable() == 1) {
				editAlojamiento.setAvailable(0);
			}else {
				editAlojamiento.setAvailable(1);
			}
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
		} else
			throw new CustomBadRequestException("No se ha podido realizar la operacion");

	}

}
