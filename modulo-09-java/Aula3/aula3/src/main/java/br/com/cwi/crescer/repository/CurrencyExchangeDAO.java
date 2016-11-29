package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.CurrencyExchange;
import java.util.List;
import javax.persistence.EntityManager;

public class CurrencyExchangeDAO implements iDao<CurrencyExchange, Long> {

    private final EntityManager em;

    public CurrencyExchangeDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(CurrencyExchange ce) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (ce.getIdCurrencyExchange() != null) {
                    em.merge(ce);
                } else {
                    em.persist(ce);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public CurrencyExchange find(Long id) {
        CurrencyExchange ce = null;
        if (em.isOpen()) {
            try {
                ce = em.find(CurrencyExchange.class, id);
            } catch (Exception e) {
                System.err.println("Problema na requisição ao banco de dados.");
            }
        }
        return ce;
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
