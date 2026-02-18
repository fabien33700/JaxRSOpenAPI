package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.ConcertDao;
import fr.istic.taa.jaxrs.domain.Concert;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("concerts")
@Produces({"application/json"})
public class ConcertResource {

  private final ConcertDao dao = new ConcertDao();

  @GET
  @Path("/{id}")
  public Concert getConcertById(@PathParam("id") Long id)  {
      return dao.findOne(id);
  }

  @GET
  @Path("/")
  public List<Concert> getConcerts()  {
      return dao.findAll();
  }
}