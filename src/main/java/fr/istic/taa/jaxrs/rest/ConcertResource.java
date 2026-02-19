package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Concert;
import fr.istic.taa.jaxrs.dto.ConcertCreateDTO;
import fr.istic.taa.jaxrs.services.ConcertService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("concerts")
@Produces({"application/json"})
public class ConcertResource {

  private final ConcertService service = new ConcertService();

  @GET
  @Path("/{id}")
  public Concert getConcertById(@PathParam("id") Long id)  {
      return service.findOne(id);
  }

  @GET
  @Path("/")
  public List<Concert> getConcerts()  {
      return service.findAll();
  }

  @POST
  @Path("/")
  @Consumes("application/json")
  public Response createConcert(final @Valid ConcertCreateDTO concert) throws URISyntaxException {
    long id = service.create(concert);
    URI uri = new URI("/concerts/" + id);
    return Response.created(uri).build();
  }
}