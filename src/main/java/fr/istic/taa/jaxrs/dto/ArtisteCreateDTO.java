package fr.istic.taa.jaxrs.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class ArtisteCreateDTO {
    @NotEmpty
    private String nomScene;

    @NotNull
    private LocalDate dateNaissance;

    @Min(0)
    @Max(100)
    private int popularite;

    @Length(min = 2, max = 2)
    private String nationalite;

    public String getNomScene() {
        return nomScene;
    }

    public void setNomScene(String nomScene) {
        this.nomScene = nomScene;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getPopularite() {
        return popularite;
    }

    public void setPopularite(int popularite) {
        this.popularite = popularite;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
}
