package br.com.rest;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.dao.CantorDAO;
import br.com.model.Cantor;

@Path("/cantor")
public class CantorREST {

	CantorDAO cDAO = null;

	public CantorREST() {
		this.cDAO = new CantorDAO();
	}
	

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCantor() throws SQLException {
		return Response.ok(cDAO.findAll()).build();
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCantor(@PathParam("id") int id) {
		return Response.ok(cDAO.findById(id)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCantor(Cantor cantor) {
		try {
				boolean result = cDAO.insert(cantor);
				if (result) {
					return Response.status(Response.Status.CREATED).entity(cantor).build();
				} else {
					return Response.status(Response.Status.NOT_MODIFIED).entity(cantor).build();
				}
			} catch (Exception e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
			}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizaCantor(Cantor cantor) {
		try {
			boolean result = cDAO.update(cantor);
			if (result) {
				return Response.status(Response.Status.CREATED).entity(cantor).build();
			} else {
				return Response.status(Response.Status.NOT_MODIFIED).entity(cantor).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletaCantor(@PathParam("id") int id) {
		try {
			boolean result = cDAO.delete(cDAO.findById(id));
			if (result) {
				return Response.status(Response.Status.OK).build();
			} else {
				return Response.status(Response.Status.NOT_MODIFIED).build();
				
			}
		} catch (Exception e) {
			    return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
