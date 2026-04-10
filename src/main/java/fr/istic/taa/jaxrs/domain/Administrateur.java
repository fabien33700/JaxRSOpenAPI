package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import javax.management.relation.Role;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("administrateur")
public class Administrateur extends Personne {
    private LocalDate dateNomination;

    private Boolean actif;

    // region Generated code
    public LocalDate getDateNomination() {
        return dateNomination;
    }

    public void setDateNomination(LocalDate dateNomination) {
        this.dateNomination = dateNomination;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    @Transient
    @Override
    public RoleEnum getRole() {
        return RoleEnum.ADMINISTRATEUR;
    }

    @Override
    public String toString() {
        return "Administrateur{" +
                "dateNomination=" + dateNomination +
                ", actif=" + actif +
                ", personneId=" + personneId +
                '}';
    }

    // endregion
}
