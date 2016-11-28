package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import static org.hibernate.criterion.MatchMode.ANYWHERE;
import org.hibernate.criterion.Restrictions;

public class PessoaDAO implements iDao<Pessoa, Long> {

    private final EntityManager em;

    public PessoaDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(final Pessoa pessoa) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (pessoa.getIdPessoa() != null) {
                    em.merge(pessoa);
                } else {
                    em.persist(pessoa);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public Pessoa find(Long id) {
        Pessoa pessoa = null;
        if (em.isOpen()) {
            try {
                pessoa = em.find(Pessoa.class, id);
            } catch (Exception e) {
                System.err.println("Problema na requisição ao banco de dados.");
            }
        }
        return pessoa;
    }

    @Override
    public void delete(Pessoa pessoa) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (pessoa.getIdPessoa() != null) {
                    em.remove(pessoa);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public List<Pessoa> findAll() {
        return em.createQuery("SELECT p FROM Pessoa p").getResultList();
    }

    @Override
    public List<Pessoa> findByName(String nome) {
        final Session session = em.unwrap(Session.class);
        final Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Restrictions.like("nmPessoa", nome, ANYWHERE));
        return criteria.list();
    }
}
