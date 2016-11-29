package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

public class CurrencyExchangeDAO implements iDao<CurrencyExchange, Long> {

    private final EntityManager em;

    public CurrencyExchangeDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(CurrencyExchange ce) {
        em.getTransaction().begin();
        Session session = em.unwrap(Session.class);
        if (ce.getIdCurrencyExchange() == null) {
            session.save(ce);
        } else {
            session.update(ce);
        }
        em.getTransaction().commit();
    }

    @Override
    public CurrencyExchange find(Long id) {
        Session session = em.unwrap(Session.class);
        return (CurrencyExchange) session.load(CurrencyExchange.class, id);
    }

    @Override
    public List<CurrencyExchange> findAll() {
        return em.createQuery("SELECT c FROM CurrencyExchange c").getResultList();
    }

    @Override
    public List<CurrencyExchange> findByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(CurrencyExchange ce) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (ce.getIdCurrencyExchange() != null) {
                    em.remove(ce);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

}
