package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.ArtisteDao;
import fr.istic.taa.jaxrs.domain.Artiste;
import fr.istic.taa.jaxrs.dto.ArtisteSearchDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

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
  public List<Artiste> findArtistes(@Context UriInfo info) {
    ArtisteSearchDTO searchDTO = new ArtisteSearchDTO(info.getQueryParameters());
      return dao.searchArtistes(searchDTO);
  }
}