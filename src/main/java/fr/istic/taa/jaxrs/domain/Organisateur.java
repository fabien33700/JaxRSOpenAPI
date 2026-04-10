package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("organisateur")
public class Organisateur extends Personne {

    private String nomStructure;

    private String numeroSiret;

    private String adresseSiege;

    private Boolean actif;

    @Transient
    @Override
    public RoleEnum getRole() {
        return RoleEnum.ORGANISATEUR;
    }

    // region Generated code
    public String getNomStructure() {
        return nomStructure;
    }

    public void setNomStructure(String nomStructure) {
        this.nomStructure = nomStructure;
    }

    public String getNumeroSiret() {
        return numeroSiret;
    }

    public void setNumeroSiret(String numeroSiret) {
        this.numeroSiret = numeroSiret;
    }

    public String getAdresseSiege() {
        return adresseSiege;
    }

    public void setAdresseSiege(String adresseSiege) {
        this.adresseSiege = adresseSiege;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return "Organisateur{" +
                "nomStructure='" + nomStructure + '\'' +
                ", numeroSiret='" + numeroSiret + '\'' +
                ", adresseSiege='" + adresseSiege + '\'' +
                ", actif=" + actif +
                ", personneId=" + personneId +
                '}';
    }


    // endregion
}
