package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.ArtisteDao;
import fr.istic.taa.jaxrs.domain.Artiste;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("artistes")
@Produces({"application/json"})
public class ArtisteResource {

  private final ArtisteDao dao = new ArtisteDao();

  @GET
  @Path("/{id}")
  public Artiste getArtisteById(@PathParam("id") Long id)  {
      return dao.findOne(id);
  }

  @GET
  @Path("/")
  public List<Artiste> getArtistes()  {
      return dao.findAll();
  }
}