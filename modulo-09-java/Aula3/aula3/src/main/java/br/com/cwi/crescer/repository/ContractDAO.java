package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.Contract;
import br.com.cwi.crescer.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;

public class ContractDAO implements iDao<Contract, Long> {

    private final EntityManager em;

    public ContractDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Contract contract) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (contract.getIdContract() != null) {
                    em.merge(contract);
                } else {
                    em.persist(contract);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public Contract find(Long id) {
        Contract contract = null;
        if (em.isOpen()) {
            try {
                contract = em.find(Contract.class, id);
            } catch (Exception e) {
                System.err.println("Problema na requisição ao banco de dados.");
            }
        }
        return contract;
    }

    @Override
    public List findAll() {
        return em.createQuery("SELECT c FROM Contract c").getResultList();
    }

    @Override
    public List findByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Contract contract) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (contract.getIdContract() != null) {
                    em.remove(contract);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

}
