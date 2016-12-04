package br.com.cwi.crescer.exerc.aula5.entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioBean extends AbstractDao<Usuario, Long>  {
    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<Usuario> findAll() {
        return this.getEntityManager().createQuery("select u from Usuario u").getResultList();
    }
}
