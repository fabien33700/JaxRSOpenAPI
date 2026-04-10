package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.OrganisateurDao;
import fr.istic.taa.jaxrs.dao.PersonneDao;
import fr.istic.taa.jaxrs.domain.Organisateur;
import fr.istic.taa.jaxrs.domain.Personne;
import fr.istic.taa.jaxrs.dto.LoginDTO;
import fr.istic.taa.jaxrs.utils.JwtUtil;
import fr.istic.taa.jaxrs.utils.PasswordUtil;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    private final PersonneDao personneDao = new PersonneDao();

    record LoginResponse(String token, String role) {}

    @POST
    @Path("/login")
    public Response login(@Valid LoginDTO loginDTO) {
        Personne personne = personneDao.findByEmail(loginDTO.getEmail());

        if (personne == null || !PasswordUtil.verify(loginDTO.getPassword(), personne.getHashPassword())) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        String roleName = personne.getRole().name().toLowerCase();
        String token = JwtUtil.generateToken(personne.getEmail(), roleName);

        return Response.ok(new LoginResponse(token, roleName)).build();
    }
}
