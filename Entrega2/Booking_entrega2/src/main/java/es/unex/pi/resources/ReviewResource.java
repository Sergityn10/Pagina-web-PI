package es.unex.pi.resources;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.dao.*;
import es.unex.pi.model.*;
import es.unex.pi.model.User;
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

@Path("/reviews")
public class ReviewResource {

	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	private static final Logger logger = Logger.getLogger(HttpServlet.class.getName());

	// FUNCIONA
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> getReviewsJSON(@Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Review> reviews;

		reviews = reviewDao.getAllByUser(user.getId());

		return reviews;
	}

	// FUNCIONA
	@GET
	@Path("/{reviewid: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Review getReviewByIdJSON(@PathParam("reviewid") long reviewid, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Review review = new Review();

		return reviewDao.get(reviewid, user.getId());
	}
	// FUNCIONA LA OPERACION POST CON JSON

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createReview(Review review, @Context HttpServletRequest request) {
		Response res;

		Connection conn = (Connection) sc.getAttribute("dbConn");
		
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);
		
		PropertyDAO propDao = new JDBCPropertyDAOImpl();
		propDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (propDao.get(review.getIdp()) != null && user.getId() == review.getIdu()
				&& reviewDao.get(review.getIdp(), review.getIdu()) == null) {
			reviewDao.add(review);
			res = Response // return 201 and Location: /orders/newid
					.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(review.getIdp())).build())
					.contentLocation(uriInfo.getAbsolutePathBuilder().path(Long.toString(review.getIdp())).build())
					.build();
			return res;
		} else {
			throw new CustomBadRequestException("No se ha podido realizar la operacion");
		}
	}

	// FUNCIONA EL POST DE UNA REVIEW
	@POST
	@Path("/{reviewid: [0-9]+}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response postReview(@PathParam("reviewid") long idp, @FormParam("num_valoracion") int valoracion,
			@FormParam("descripcion") String descripcion, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Review review = new Review();
		review.setGrade(valoracion);
		review.setIdp(idp);
		review.setIdu(user.getId());
		review.setReview(descripcion);
		Response res = null;

		if (reviewDao.get(review.getIdp(), review.getIdu()) == null) {
			reviewDao.add(review);
			logger.info("POST de la review: idp->" + review.getIdp() + ", idu->" + review.getIdu());
			res = Response // return 201 and Location: /orders/newid
					.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(idp)).build())
					.contentLocation(uriInfo.getAbsolutePathBuilder().path(Long.toString(idp)).build()).build();
			return res;
		} else
			throw new CustomBadRequestException("Ya existe una review por este usuario");

	}

	// funciona el PUT con JSON
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response putReviewJSON(Review review, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Response res = null;

		if (reviewDao.get(review.getIdp(), review.getIdu()) != null) {
			if (review.getIdu() == user.getId()) {
				reviewDao.update(review);
				logger.info(
						"PUT utilizando un JSON de la review: idp->" + review.getIdp() + ", idu->" + review.getIdu());
				res = Response // return 201 and Location:
						.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(review.getIdp())).build())
						.contentLocation(uriInfo.getAbsolutePathBuilder().path(Long.toString(review.getIdp())).build())
						.build();
				return res;
			} else
				throw new CustomBadRequestException("No puedes realizar un actualización de una review que no es tuya");

		} else
			throw new CustomNotFoundException("No se ha podido encontrar o actualizar la review deseada");

	}

	// Funciona el PUT a partir de un formulario
	@PUT
	@Path("/{reviewid: [0-9]+}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateReview(@PathParam("reviewid") long idp, @FormParam("num_valoracion") int valoracion,
			@FormParam("descripcion") String descripcion, @Context HttpServletRequest request) {
		Connection conn = (Connection) sc.getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Review review = new Review();
		review.setGrade(valoracion);
		review.setIdp(idp);
		review.setIdu(user.getId());
		review.setReview(descripcion);
		Response res = null;

		if (reviewDao.get(review.getIdp(), review.getIdu()) != null) {
			reviewDao.update(review);
			logger.info("PUT de la review: idp->" + review.getIdp() + ", idu->" + review.getIdu());
			res = Response // return 201 and Location: /orders/newid
					.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(idp)).build())
					.contentLocation(uriInfo.getAbsolutePathBuilder().path(Long.toString(idp)).build()).build();
			return res;
		} else
			throw new CustomNotFoundException("No se ha podido encontrar o actualizar la review deseada");

	}

	// FUNCIONA EL DELETE DE UNA REVIEW
	@DELETE
	@Path("/{reviewid: [0-9]+}")
	public Response deleteOrder(@PathParam("reviewid") long reviewid, @Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);
		logger.info("API DELETE by idp: " + reviewid);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Review review = reviewDao.get(reviewid, user.getId());
		if ((review != null) && (user.getId() == review.getIdu())) {
			reviewDao.delete(reviewid, user.getId());
			return Response.noContent().build(); // 204 no content
		} else
			throw new CustomBadRequestException("Error in user or id");
	}

	// FUNCIONA EL DELETE EN CASCADA
	@DELETE
	public Response deleteAllOrdersUser(@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		ReviewDAO reviewDao = new JDBCReviewDAOImpl();
		reviewDao.setConnection(conn);

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			List<Review> listReviewUser = reviewDao.getAllByUser(user.getId());
			Iterator<Review> iterador = listReviewUser.iterator();
			while (iterador.hasNext()) {
				Review itReview = iterador.next();
				reviewDao.delete(itReview.getIdp(), user.getId());
				logger.info("DELETE review con idp = " + itReview.getIdp() + " y con idu = " + itReview.getIdu());
			}
			return Response.noContent().build();
		}

		else
			throw new CustomBadRequestException(
					"Debes iniciar sesión para poder realizar el borrado de todas tus reviews");
	}
}
