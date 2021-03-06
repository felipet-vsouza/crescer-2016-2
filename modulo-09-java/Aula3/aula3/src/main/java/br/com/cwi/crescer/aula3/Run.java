package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.entity.CurrencyExchange;
import br.com.cwi.crescer.repository.CurrencyExchangeDAO;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) {
        final EntityManager em;
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER16");
        em = emf.createEntityManager();
        CurrencyExchangeDAO dao = new CurrencyExchangeDAO(em);
        
        CurrencyExchange ce = new CurrencyExchange();
        ce.setDsCoin("moeda");
        dao.insert(ce);
//        dao.findAll().stream().forEach((c) -> {
//            System.out.println(c.getDsCoin()+ " - " + c.getDtCurrencyExchange().toString());
//        });
        
        em.close();
        emf.close();
    }
}
