package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.entity.Client;
import br.com.cwi.crescer.repository.ClientDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Run {

    public static void main(String[] args) {
        final EntityManager em;
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER16");
        em = emf.createEntityManager();
        ClientDAO dao = new ClientDAO(em);

        Client client = new Client();
        client.setDsEmail("caroline.lentz2@gmail.com");
        client.setDsPassword("dsdijasdoa2371e$$%531423");
        client.setDsPreferredCoin("Yen");
        client.setDsState("RS");
        client.setDsUserName("Carolzera");
        client.setNmClient("Caroline Lentz");
        client.setTpPermission("cheats_enabled true");
        
        dao.insert(client);
        
        em.close();
        emf.close();
    }
}
