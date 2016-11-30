package br.com.cwi.crescer.exerc.aula5.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GeneroBean extends AbstractDao<Genero, Long> {
    
    @PersistenceContext(unitName = "br.com.cwi.crescer_exerc-aula5_war_1.0.0.0PU")
    private EntityManager entityManager;

    public GeneroBean() {
        super(Genero.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Genero> findAll() {
        return this.getEntityManager().createQuery("select a from Ator a").getResultList();
    }
}
