package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.entity.Pessoa;
import br.com.cwi.crescer.repository.PessoaDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) {
        final EntityManager em;
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER16");
        em = emf.createEntityManager();
        PessoaDAO dao = new PessoaDAO(em);
//        Pessoa p = new Pessoa();
//        p.setIdPessoa(3l);
//        p.setNmPessoa("Felpera");
//        dao.insert(p);

        dao.findByName("zue").stream().forEach((Pessoa pes) -> System.out.format("%d - %s\n",
                pes.getIdPessoa(), pes.getNmPessoa()));

        em.close();
        emf.close();
    }
}
