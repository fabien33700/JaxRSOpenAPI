package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.dto.TicketCreateDTO;
import fr.istic.taa.jaxrs.services.TicketService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("tickets")
@Produces({"application/json"})
public class TicketResource {

  private final TicketService service = new TicketService();

  @GET
  @Path("/{id}")
  public Ticket getTicketById(@PathParam("id") Long id)  {
      return service.findOne(id);
  }

  @GET
  @Path("/")
  public List<Ticket> getAllTickets()  {
      return service.findAll();
  }

  @POST
  @Path("/")
  @Consumes("application/json")
  public Response createTicket(final @Valid TicketCreateDTO ticket) throws URISyntaxException {
    long id = service.create(ticket);
    URI uri = new URI("/tickets/" + id);
    return Response.created(uri).build();
  }
}