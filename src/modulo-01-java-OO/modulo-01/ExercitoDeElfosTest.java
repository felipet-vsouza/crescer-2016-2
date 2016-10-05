import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ExercitoDeElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExercitoDeElfosTest
{
    @Test
    public void exercitoDeElfosAlistaTresElfosDeCadaRaca() {
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("Daisuke", 8), 
            not3 = new ElfoNoturno("Helmet", 22);
        ElfoVerde ver1 = new ElfoVerde("Dylan", 1), ver2 = new ElfoVerde("Corrina", 1), 
            ver3 = new ElfoVerde("Woman from the north country side", 1);
        ExercitoDeElfos nords = new ExercitoDeElfos();
        nords.alistarElfo(not1);
        nords.alistarElfo(not2);
        nords.alistarElfo(not3);
        nords.alistarElfo(ver1);
        nords.alistarElfo(ver2);
        nords.alistarElfo(ver3);
        assertTrue(nords.getContingente().contains(new ElfoNoturno("El Huervo", 13)));
        assertTrue(nords.getContingente().contains(new ElfoNoturno("Daisuke", 8)));
        assertTrue(nords.getContingente().contains( new ElfoNoturno("Helmet", 22)));
        assertTrue(nords.getContingente().contains(new ElfoVerde("Dylan", 1)));
        assertTrue(nords.getContingente().contains(new ElfoVerde("Corrina", 1)));
        assertTrue(nords.getContingente().contains(new ElfoVerde("Woman from the north country side", 1)));
    }
    
    @Test
    public void exercitoDeElfosAlistaTresElfosDeCadaRacaEBuscaElHuervo() {
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("Daisuke", 8), 
            not3 = new ElfoNoturno("Helmet", 22);
        ElfoVerde ver1 = new ElfoVerde("Dylan", 1), ver2 = new ElfoVerde("Corrina", 1), 
            ver3 = new ElfoVerde("Woman from the north country side", 1);
        ExercitoDeElfos nords = new ExercitoDeElfos();
        nords.alistarElfo(not1);
        nords.alistarElfo(not2);
        nords.alistarElfo(not3);
        nords.alistarElfo(ver1);
        nords.alistarElfo(ver2);
        nords.alistarElfo(ver3);
        assertEquals(new ElfoNoturno("El Huervo", 13), nords.buscarPeloNome("El Huervo"));
    }
    
    @Test
    public void exercitoDeElfosBuscarElfoEmContingenteVazio() {
        ExercitoDeElfos nords = new ExercitoDeElfos();
        assertNull(nords.buscarPeloNome("El Huervo"));
    }
    
    @Test
    public void exercitoDeElfosBuscarElfoComNomeDuplicadoEReceberOPrimeiro() {
        ExercitoDeElfos nords = new ExercitoDeElfos();
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("El Huervo", 13);
        not1.atirarFlecha(new Dwarf());
        not1.atirarFlecha(new Dwarf());
        nords.alistarElfo(not1);
        nords.alistarElfo(not2);
        assertFalse(not1.equals(not2));
        assertTrue(nords.buscarPeloNome("El Huervo").equals(not1));
    }
    
    @Test
    public void exercitoDeElfosNaoRecebeElfosQueNaoSejamElfosVerdesOuElfosNoturnos() {
        ExercitoDeElfos nords = new ExercitoDeElfos();
        nords.alistarElfo(new Elfo("Melita"));
        nords.alistarElfo(new ElfoVerde("Café Pelé"));
        nords.alistarElfo(new ElfoNoturno("Café do Mercado"));
        assertNull(nords.buscarPeloNome("Melita"));
        assertEquals(new ElfoVerde("Café Pelé"), nords.buscarPeloNome("Café Pelé"));
        assertEquals(new ElfoNoturno("Café do Mercado"), nords.buscarPeloNome("Café do Mercado"));
    }
    
    @Test
    public void exercitoDeElfosRetornaListaComUmElfoMorto() {
        ElfoNoturno elfo1 = new ElfoNoturno("Renato Aragão", 1000);
        for(int i = 0; i <= 200; i++){
            elfo1.atirarFlecha(new Dwarf());
        }
        ElfoVerde elfo2 = new ElfoVerde("Didi Mocó");
        ExercitoDeElfos elfada = new ExercitoDeElfos();
        elfada.alistarElfo(elfo1);
        elfada.alistarElfo(elfo2);
        ArrayList<Elfo> lista = elfada.buscar(Status.MORTO);
        assertEquals(Status.MORTO, elfo1.getStatus());
        assertEquals(1, lista.size());
        assertTrue(lista.get(0).getNome().equals("Renato Aragão"));
    }
    
    @Test
    public void exercitoDeElfosRetornaListaComDoisElfosVivos() {
        ElfoNoturno elfo1 = new ElfoNoturno("Renato Aragão", 1000);
        for(int i = 0; i <= 200; i++){
            elfo1.atirarFlecha(new Dwarf());
        }
        ElfoVerde elfo2 = new ElfoVerde("Didi Mocó");
        ElfoVerde elfo3 = new ElfoVerde("Spongebob Squarepants");
        ExercitoDeElfos elfada = new ExercitoDeElfos();
        elfada.alistarElfo(elfo1);
        elfada.alistarElfo(elfo2);
        elfada.alistarElfo(elfo3);
        ArrayList<Elfo> lista = elfada.buscar(Status.VIVO);
        assertEquals(2, lista.size());
        assertTrue(lista.get(0).getNome().equals("Didi Mocó"));
        assertTrue(lista.get(1).getNome().equals("Spongebob Squarepants"));
    }
    
    @After
    // Executa após cada um dos testes
    public void tearDown() {
        System.gc();
    }
}
