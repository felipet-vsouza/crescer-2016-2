package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.ContractValue;
import java.util.List;
import javax.persistence.EntityManager;

public class ContractValueDAO implements iDao<ContractValue, Long> {

    private final EntityManager em;

    public ContractValueDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(ContractValue cv) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (cv.getIdContractValue() != null) {
                    em.merge(cv);
                } else {
                    em.persist(cv);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public ContractValue find(Long id) {
        ContractValue cv = null;
        if (em.isOpen()) {
            try {
                cv = em.find(ContractValue.class, id);
            } catch (Exception e) {
                System.err.println("Problema na requisição ao banco de dados.");
            }
        }
        return cv;
    }

    @Override
    public List<ContractValue> findAll() {
        return em.createQuery("SELECT c FROM ContractValue c").getResultList();
    }

    @Override
    public List<ContractValue> findByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ContractValue cv) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (cv.getIdContractValue() != null) {
                    em.remove(cv);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

}
