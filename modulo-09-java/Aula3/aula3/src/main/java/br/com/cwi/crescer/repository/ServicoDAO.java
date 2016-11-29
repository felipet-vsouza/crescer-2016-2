package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.Servico;
import java.util.List;
import javax.persistence.EntityManager;

public class ServicoDAO implements iDao<Servico, Long> {

    private final EntityManager em;

    public ServicoDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Servico servico) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (servico.getIdServico() != null) {
                    em.merge(servico);
                } else {
                    em.persist(servico);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public Servico find(Long id) {
        Servico servico = null;
        if (em.isOpen()) {
            try {
                servico = em.find(Servico.class, id);
            } catch (Exception e) {
                System.err.println("Problema na requisição ao banco de dados.");
            }
        }
        return servico;
    }

    @Override
    public List<Servico> findAll() {
        return em.createQuery("SELECT s FROM Servico s").getResultList();
    }

    @Override
    public List<Servico> findByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Servico servico) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (servico.getIdServico() != null) {
                    em.remove(servico);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

}
