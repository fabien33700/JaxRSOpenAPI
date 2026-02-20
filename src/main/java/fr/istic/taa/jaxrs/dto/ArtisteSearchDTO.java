package fr.istic.taa.jaxrs.dto;

import jakarta.ws.rs.core.MultivaluedMap;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ArtisteSearchDTO {
    private String nomScene;

    private String nom;

    private String prenom;

    private String nationalite;

    private Integer popularite;

    public ArtisteSearchDTO(MultivaluedMap<String, String> queryParameters) {
        this.nomScene = queryParameters.getFirst("nomScene");
        this.nom = queryParameters.getFirst("nom");
        this.prenom = queryParameters.getFirst("prenom");
        this.nationalite = queryParameters.getFirst("nationalite");

        try {
            this.popularite = Integer.parseInt(queryParameters.getFirst("popularite"));
        } catch (NumberFormatException e) {
            this.popularite = null;
        }

    }

    // region Generated code
    public Integer getPopularite() {
        return popularite;
    }

    public void setPopularite(Integer popularite) {
        this.popularite = popularite;
    }

    public String getNomScene() {
        return nomScene;
    }

    public void setNomScene(String nomScene) {
        this.nomScene = nomScene;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setPopularite(int popularite) {
        this.popularite = popularite;
    }

    // endregion
}
