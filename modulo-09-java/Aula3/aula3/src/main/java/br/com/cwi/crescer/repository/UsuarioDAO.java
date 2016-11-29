package br.com.cwi.crescer.repository;

import br.com.cwi.crescer.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

public class UsuarioDAO implements iDao<Usuario, Long> {

    private final EntityManager em;

    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void insert(Usuario usuario) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (usuario.getIdUsuario() != null) {
                    em.merge(usuario);
                } else {
                    em.persist(usuario);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    @Override
    public Usuario find(Long id) {
        Usuario usuario = null;
        if (em.isOpen()) {
            try {
                usuario = em.find(Usuario.class, id);
            } catch (Exception e) {
                System.err.println("Problema na requisição ao banco de dados.");
            }
        }
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        return em.createQuery("SELECT u FROM Usuario u").getResultList();
    }

    @Override
    public List<Usuario> findByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario usuario) {
        if (em.isOpen()) {
            em.getTransaction().begin();
            try {
                if (usuario.getIdUsuario() != null) {
                    em.remove(usuario);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

}
