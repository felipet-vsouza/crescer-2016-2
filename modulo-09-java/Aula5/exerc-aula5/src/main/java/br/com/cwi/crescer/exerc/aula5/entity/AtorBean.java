package br.com.cwi.crescer.exerc.aula5.entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AtorBean extends AbstractDao<Ator, Long> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public AtorBean() {
        super(Ator.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Ator> findAll() {
        final Query query = entityManager.createQuery("SELECT a FROM Ator a");
        final List resultList = query.getResultList();
        return resultList;
    }
}
