package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.TicketDao;
import fr.istic.taa.jaxrs.domain.Ticket;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("tickets")
@Produces({"application/json"})
public class TicketResource {

  private final TicketDao dao = new TicketDao();

  @GET
  @Path("/{id}")
  public Ticket getTicketById(@PathParam("id") Long id)  {
      return dao.findOne(id);
  }

  @GET
  @Path("/")
  public List<Ticket> getAllTickets()  {
      return dao.findAll();
  }

  @DELETE
  @Path("/{id}")
  public Response deleteTicketById(@PathParam("id") Long id)  {
    dao.deleteById(id);
    return Response.noContent().build();
  }
}