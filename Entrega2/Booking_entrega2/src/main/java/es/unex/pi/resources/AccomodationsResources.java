package es.unex.pi.resources;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.JDBCAccommodationDAOImpl;
import es.unex.pi.dao.JDBCPropertyDAOImpl;
import es.unex.pi.dao.JDBCReviewDAOImpl;
import es.unex.pi.dao.PropertyDAO;
import es.unex.pi.dao.AccommodationDAO;
import es.unex.pi.dao.ReviewDAO;
import es.unex.pi.model.Accommodation;
import es.unex.pi.model.Property;
import es.unex.pi.model.Review;
import es.unex.pi.model.User;
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

@Path("/accoms")
public class AccomodationsResources {
	@Context
	  ServletContext sc;
	  @Context
	  UriInfo uriInfo;
	  private static final Logger logger = Logger.getLogger(HttpServlet.class.getName()); 
	  
	 
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<Accommodation> getAccommodationsJSON(@Context HttpServletRequest request) {
		  Connection conn = (Connection) sc.getAttribute("dbConn");
			AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
			accomDao.setConnection(conn);
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
		
	    return accomDao.getAll();
	  }
	  
	  
	  @GET
	   @Path("/props/{idp: [0-9]+}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<Accommodation> getAccommodationsByIdpJSON(@PathParam("idp") long idp,@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
		accomDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
	    return accomDao.getAllBySearchIdp(idp); 
	  }
	  
	  @GET
	   @Path("/{idAccom:[0-9]+}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Accommodation getAccommodationJSON(@PathParam("idAccom") long idAccom,@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
		accomDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
	    return accomDao.get(idAccom); 
	  }
	 
		
		  @POST
		  @Consumes (MediaType.APPLICATION_JSON) 
		  public Response createAccommodation(Accommodation accom, 
				  @Context HttpServletRequest request) { 
			  Response res;
		  
			Connection conn = (Connection) sc.getAttribute("dbConn");
			ReviewDAO reviewDao = new JDBCReviewDAOImpl();
			reviewDao.setConnection(conn);
			PropertyDAO propDao = new JDBCPropertyDAOImpl();
			propDao.setConnection(conn);
			AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
			accomDao.setConnection(conn);
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
		  
			if(propDao.get(accom.getIdp()) != null && user.getId()== propDao.get(accom.getIdp()).getIdu() ) {
				accomDao.add(accom);
				res = Response //return 201 and Location: /orders/newid 
				  .created(
		  uriInfo.getAbsolutePathBuilder() .path(Long.toString(accom.getId())) .build())
		  .contentLocation( uriInfo.getAbsolutePathBuilder() .path(Long.toString(accom.getIdp()))
		  .build()).build();
				  return res; 
			}
			else {
				throw new CustomBadRequestException("Error al insertar una nueva habitación. Comprueba que lo estes añadiendo a un alojamiento tuyo o que al alojamiento que lo quieras referenciar exista.");
			}
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
	  
	  @POST
	  @Path("/{idp: [0-9]+}")
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public Response postReview(@PathParam("idp")long idp,
			  @FormParam("nombre") String nombreAccom, 
			  @FormParam("descripcion-hab") String descripcion,
			  @FormParam("precio-hab") int precio,
			  @FormParam("disponibles") int num_disponibles,
			  @Context HttpServletRequest request) {
		  Connection conn = (Connection) sc.getAttribute("dbConn");
		  	PropertyDAO propDao = new JDBCPropertyDAOImpl();
			propDao.setConnection(conn);
			AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
			accomDao.setConnection(conn);
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			
			
		  Response res = null;
		  if(user != null) {
			  if(propDao.get(idp).getIdu() == user.getId()) {
				Accommodation accommodation = new Accommodation();
				accommodation.setDescription(descripcion);
				accommodation.setIdp(idp);
				accommodation.setName(nombreAccom);
				accommodation.setNumAccommodations(num_disponibles);
				accommodation.setPrice(precio);
				  accomDao.add(accommodation);
				  logger.info("POST del accommodation por un formulario: idp->" + accommodation.getIdp()+ ", idu->" + accommodation.getId());
				  res = Response //return 201 and Location: /orders/newid
					   .created(
						uriInfo.getAbsolutePathBuilder()
							   .path(Long.toString(idp))
							   .build())
					   .contentLocation(
						uriInfo.getAbsolutePathBuilder()
						       .path(Long.toString(idp))
						       .build())
						.build();
			  return res;
			  }
			  else throw new CustomBadRequestException("No puedes añadir una habitación a un alojamiento que no este tuyo.");
		  }
		  else throw new CustomBadRequestException("Debes iniciar sesión para poder añadir una habitacion a un alojamiento");
		  
		  
		  
		  
	  }
	  
	  //funciona el PUT con JSON
	  @PUT
	  @Consumes(MediaType.APPLICATION_JSON)
	  public Response putAccommodationJSON(Accommodation accom,
			  @Context HttpServletRequest request) {
		  Connection conn = (Connection) sc.getAttribute("dbConn");
		  	PropertyDAO propDao = new JDBCPropertyDAOImpl();
			propDao.setConnection(conn);
			AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
			accomDao.setConnection(conn);
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			
		  Response res = null;
		  if(user != null) {
			  if(accomDao.get(accom.getId()) != null ) {
				  if(propDao.get(accom.getIdp()).getIdu() == user.getId()) {
					 accomDao.update(accom);
				  logger.info("PUT utilizando un JSON del accommodation: idp->" + accom.getIdp()+ ", idu->" + accom.getId());
				  res = Response //return 201 and Location: 
					   .created(
						uriInfo.getAbsolutePathBuilder()
							   .path(Long.toString(accom.getId()))
							   .build())
					   .contentLocation(
						uriInfo.getAbsolutePathBuilder()
						       .path(Long.toString(accom.getIdp()))
						       .build())
						.build(); 
				  	return res;
				  }
				  else throw new CustomBadRequestException("No puedes realizar un actualización de un alojamiento que no es tuyo");
		  
			  }
			  else throw new CustomNotFoundException("No se puede actualizar una habitacion que no existe");		  
		  }
		  else throw new CustomBadRequestException("Debes iniciar sesión para poder actualizar una habitacion a un alojamiento");
		  
	  }
	  
	  //Funciona el PUT a partir de un formulario
	  @PUT
	  @Path("/{ida: [0-9]+}")
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public Response putAccommodation(@PathParam("ida")long ida,
			  @FormParam("nombre") String nombreAccom, 
			  @FormParam("descripcion-hab") String descripcion,
			  @FormParam("precio-hab") int precio,
			  @FormParam("disponibles") int num_disponibles,
			  @Context HttpServletRequest request) {
		  Connection conn = (Connection) sc.getAttribute("dbConn");
		  	PropertyDAO propDao = new JDBCPropertyDAOImpl();
			propDao.setConnection(conn);
			AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
			accomDao.setConnection(conn);
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			


			Response res = null;
			if(user != null) {
				if(propDao.get(accomDao.get(ida).getIdp()).getIdu() == user.getId()) {
					if(accomDao.get(ida) != null ) {
						Accommodation accommodation = new Accommodation();
						accommodation.setDescription(descripcion);
						accommodation.setIdp(propDao.get(accomDao.get(ida).getIdp()).getId());
						accommodation.setName(nombreAccom);
						accommodation.setNumAccommodations(num_disponibles);
						accommodation.setPrice(precio);
						accomDao.update(accommodation);
						logger.info("POST del accommodation por un formulario: idp->" + accommodation.getIdp()+ ", idu->" + accommodation.getId());
						res = Response //return 201 and Location: /orders/newid
								.created(
										uriInfo.getAbsolutePathBuilder()
										.path(Long.toString(ida))
										.build())
								.contentLocation(
										uriInfo.getAbsolutePathBuilder()
										.path(Long.toString(accommodation.getIdp()))
										.build())
								.build();
						return res;
					}
					else throw new CustomNotFoundException("No se puede actualizar una habitacion que no existe");
			  }
			  else throw new CustomBadRequestException("No puedes actualizar una habitación a un alojamiento que no este tuyo.");
		  }
		  else throw new CustomBadRequestException("Debes iniciar sesión para poder añadir una habitacion a un alojamiento");
		  
		  
		  
		  
	  }
	  
	  //FUNCIONA EL DELETE DE UNA REVIEW
	  @DELETE
	  @Path("/{ida: [0-9]+}")	  
	  public Response deleteAccommodation(@PathParam("ida") long ida,
			  @Context HttpServletRequest request) {

		  Connection conn = (Connection) sc.getAttribute("dbConn");
		  PropertyDAO propDao = new JDBCPropertyDAOImpl();
		  propDao.setConnection(conn);
		  AccommodationDAO accomDao = new JDBCAccommodationDAOImpl();
		  accomDao.setConnection(conn);

		  logger.info("API DELETE Accommodation by ida: "+ida);
		  HttpSession session = request.getSession();
		  User user = (User) session.getAttribute("user");


		  if (user != null){
			  if(accomDao.get(ida)!= null) {
				  if(user.getId() == propDao.get(accomDao.get(ida).getIdp()).getIdu()) {
					  accomDao.delete(ida);
					  return Response.noContent().build(); //204 no content 
				  }
				  else throw new CustomBadRequestException("No puedes eliminar una habitación a un alojamiento que no este tuyo.");
			  }
			  else throw new CustomNotFoundException("No se puede eliminar una habitacion que no existe");
		  }
		  else throw new CustomBadRequestException("Error in user. Sign in");		
	  }

	  //FUNCIONA EL DELETE EN CASCADA
		/*
		 * @DELETE
		 * 
		 * @Path("/prop/{idp: [0-9]+}") public Response deleteAllByIdp(
		 * 
		 * @Context HttpServletRequest request) {
		 * 
		 * Connection conn = (Connection) sc.getAttribute("dbConn"); PropertyDAO propDao
		 * = new JDBCPropertyDAOImpl(); propDao.setConnection(conn); AccommodationDAO
		 * accomDao = new JDBCAccommodationDAOImpl(); accomDao.setConnection(conn);
		 * 
		 * HttpSession session = request.getSession(); User user = (User)
		 * session.getAttribute("user");
		 * 
		 * if(user != null) { if() List<Review> listReviewUser=
		 * reviewDao.getAllByUser(user.getId()); Iterator<Review> iterador =
		 * listReviewUser.iterator(); while(iterador.hasNext()) { Review itReview =
		 * iterador.next(); reviewDao.delete(itReview.getIdp(), user.getId());
		 * logger.info("DELETE review con idp = "+itReview.getIdp()+" y con idu = "
		 * +itReview.getIdu()); } return Response.noContent().build(); }
		 * 
		 * 
		 * else throw new
		 * CustomBadRequestException("Debes iniciar sesión para poder realizar el borrado de todas tus reviews"
		 * ); }
		 */
}
