package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.Cotacao;
import java.util.List;
import javax.persistence.EntityManager;

public class CotacaoDAO implements iDao<Cotacao, Long> {

    private final EntityManager em;

    public CotacaoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Cotacao cotacao) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (cotacao.getIdCotacao() != null) {
                    em.merge(cotacao);
                } else {
                    em.persist(cotacao);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public Cotacao find(Long id) {
        Cotacao cotacao = null;
        if (em.isOpen()) {
            try {
                cotacao = em.find(Cotacao.class, id);
            } catch (Exception e) {
                System.err.println("Problema na requisição ao banco de dados.");
            }
        }
        return cotacao;
    }

    @Override
    public List<Cotacao> findAll() {
        return em.createQuery("SELECT c FROM Cotacao c").getResultList();
    }

    @Override
    public List<Cotacao> findByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Cotacao cotacao) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (cotacao.getIdCotacao() != null) {
                    em.remove(cotacao);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

}
