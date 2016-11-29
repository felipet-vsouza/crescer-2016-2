package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.Client;
import br.com.cwi.crescer.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import static org.hibernate.criterion.MatchMode.ANYWHERE;
import org.hibernate.criterion.Restrictions;

public class ClientDAO implements iDao<Client, Long> {

    private final EntityManager em;

    public ClientDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Client client) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (client.getIdClient() != null) {
                    em.merge(client);
                } else {
                    em.persist(client);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public List<Client> findAll() {
        return em.createQuery("SELECT p FROM Pessoa p").getResultList();
    }

    @Override
    public List findByName(String nome) {
        final Session session = em.unwrap(Session.class);
        final Criteria criteria = session.createCriteria(Client.class);
        criteria.add(Restrictions.like("nmClient", nome, ANYWHERE));
        return criteria.list();
    }

    @Override
    public Client find(Long id) {
        Client client = null;
        if (em.isOpen()) {
            try {
                client = em.find(Client.class, id);
            } catch (Exception e) {
                System.err.println("Problema na requisição ao banco de dados.");
            }
        }
        return client;
    }

    @Override
    public void delete(Client client) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (client.getIdClient() != null) {
                    em.remove(client);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

}
