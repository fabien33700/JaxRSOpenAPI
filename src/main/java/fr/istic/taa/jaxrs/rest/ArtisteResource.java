package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.ArtisteDao;
import fr.istic.taa.jaxrs.domain.Artiste;
import fr.istic.taa.jaxrs.dto.ArtisteSearchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

@Path("artistes")
@Produces({"application/json"})
@Tag(name = "Artistes", description = "Gestion des artistes musicaux")
public class ArtisteResource {

    private final ArtisteDao dao = new ArtisteDao();

    @GET
    @Path("/{id}")
    @Operation(
            summary = "Récupérer un artiste par son identifiant",
            description = "Retourne les informations détaillées d'un artiste à partir de son identifiant unique"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Artiste trouvé avec succès",
            content = @Content(schema = @Schema(implementation = Artiste.class))
    )
    @ApiResponse(responseCode = "404", description = "Artiste non trouvé")
    public Artiste getArtisteById(
            @Parameter(description = "Identifiant unique de l'artiste", required = true)
            @PathParam("id") Long id) {
        return dao.findOne(id);
    }

    @GET
    @Path("/")
    @Operation(
            summary = "Rechercher des artistes",
            description = "Retourne la liste des artistes correspondant aux critères de recherche fournis en paramètres de requête"
    )
    @Parameter(name = "nomScene", description = "Nom de scène de l'artiste", in = ParameterIn.QUERY)
    @Parameter(name = "nom", description = "Nom de famille de l'artiste", in = ParameterIn.QUERY)
    @Parameter(name = "prenom", description = "Prénom de l'artiste", in = ParameterIn.QUERY)
    @Parameter(name = "nationalite", description = "Nationalité de l'artiste", in = ParameterIn.QUERY)
    @Parameter(name = "popularite", description = "Niveau de popularité de l'artiste", in = ParameterIn.QUERY
            , schema = @Schema(type = "integer"))
    @ApiResponse(
            responseCode = "200",
            description = "Liste des artistes correspondant aux critères",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Artiste.class)))
    )
    public List<Artiste> findArtistes(@Parameter(hidden = true) @Context UriInfo info) {
        ArtisteSearchDTO searchDTO = new ArtisteSearchDTO(info.getQueryParameters());
        return dao.searchArtistes(searchDTO);
    }
}
