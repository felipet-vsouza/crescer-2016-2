package br.com.cwi.crescer.exerc.aula5.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FilmeBean extends AbstractDao<Filme, Long> {
    
    @PersistenceContext(unitName = "br.com.cwi.crescer_exerc-aula5_war_1.0.0.0PU")
    private EntityManager entityManager;

    public FilmeBean() {
        super(Filme.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Filme> findAll() {
        return this.getEntityManager().createQuery("select a from Ator a").getResultList();
    }
}
