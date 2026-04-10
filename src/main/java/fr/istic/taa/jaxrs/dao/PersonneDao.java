package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Organisateur;
import fr.istic.taa.jaxrs.domain.Personne;
import jakarta.persistence.NoResultException;

public class PersonneDao extends AbstractJpaDao<Long, Personne> {
    public PersonneDao() {
        super(Personne.class);
    }

    public Personne findByEmail(String email) {
        try {
            return entityManager
                    .createQuery("select p from Personne p where p.email = :email", Personne.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
