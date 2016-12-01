package br.com.cwi.crescer.exerc.aula5.entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ElencoBean extends AbstractDao<Elenco, Long> {
    
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public ElencoBean() {
        super(Elenco.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Elenco> findAll() {
        return this.getEntityManager().createQuery("select a from Ator a").getResultList();
    }
}
