package br.com.rest;

import java.sql.SQLException;

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

import br.com.dao.MusicaDAO;
import br.com.model.Musica;

@Path("/musica")
public class MusicaREST {

	MusicaDAO cDAO = null;

	public MusicaREST() {
		this.cDAO = new MusicaDAO();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMusicas() throws SQLException {
		return Response.ok(cDAO.findAll()).build();
	}

	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMusica(@PathParam("id") int id) {
		return Response.ok(cDAO.findById(id)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMusica(Musica musica) {
		try {
			boolean result = cDAO.insert(musica);
			if (result) {
				return Response.status(Response.Status.CREATED).entity(musica).build();
			} else {
				return Response.status(Response.Status.NOT_MODIFIED).entity(musica).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizaMusica(Musica musica) {
		try {
			boolean result = cDAO.update(musica);
			if (result) {
				return Response.status(Response.Status.CREATED).entity(musica).build();
			} else {
				return Response.status(Response.Status.NOT_MODIFIED).entity(musica).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletaMusica(@PathParam("id") int id) {
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
