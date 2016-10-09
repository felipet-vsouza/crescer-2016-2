import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BatalhaoEspecialDeElfosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BatalhaoEspecialDeElfosTest
{
    @Test
    public void batalhaoEspecialDeElfosAlistaTresElfosDeCadaRaca() {
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("Daisuke", 8), 
            not3 = new ElfoNoturno("Helmet", 22);
        ElfoVerde ver1 = new ElfoVerde("Dylan", 1), ver2 = new ElfoVerde("Corrina", 1), 
            ver3 = new ElfoVerde("Woman from the north country side", 1);
        BatalhaoEspecialDeElfos nords = new BatalhaoEspecialDeElfos();
        nords.alistar(not1);
        nords.alistar(not2);
        nords.alistar(not3);
        nords.alistar(ver1);
        nords.alistar(ver2);
        nords.alistar(ver3);
        assertEquals(new ElfoNoturno("El Huervo", 13), nords.buscar("El Huervo"));
        assertEquals(new ElfoNoturno("Daisuke", 8), nords.buscar("Daisuke"));
        assertEquals(new ElfoNoturno("Helmet", 22), nords.buscar("Helmet"));
        assertEquals(new ElfoVerde("Dylan", 1), nords.buscar("Dylan"));
        assertEquals(new ElfoVerde("Corrina", 1), nords.buscar("Corrina"));
        assertEquals(new ElfoVerde("Woman from the north country side", 1), nords.buscar("Woman from the north country side"));
    }
    
    @Test
    public void batalhaoEspecialDeElfosAlistaTresElfosDeCadaRacaEBuscaElHuervo() {
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("Daisuke", 8), 
            not3 = new ElfoNoturno("Helmet", 22);
        ElfoVerde ver1 = new ElfoVerde("Dylan", 1), ver2 = new ElfoVerde("Corrina", 1), 
            ver3 = new ElfoVerde("Woman from the north country side", 1);
        BatalhaoEspecialDeElfos nords = new BatalhaoEspecialDeElfos();
        nords.alistar(not1);
        nords.alistar(not2);
        nords.alistar(not3);
        nords.alistar(ver1);
        nords.alistar(ver2);
        nords.alistar(ver3);
        assertEquals(new ElfoNoturno("El Huervo", 13), nords.buscar("El Huervo"));
    }
    
    @Test
    public void batalhaoEspecialDeElfosBuscarElfoEmContingenteVazio() {
        BatalhaoEspecialDeElfos nords = new BatalhaoEspecialDeElfos();
        assertNull(nords.buscar("El Huervo"));
    }
    
    @Test
    public void batalhaoEspecialDeElfosBuscarElfoComNomeDuplicadoEReceberOPrimeiro() {
        BatalhaoEspecialDeElfos nords = new BatalhaoEspecialDeElfos();
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("El Huervo", 13);
        not1.atirarFlecha(new Dwarf());
        not1.atirarFlecha(new Dwarf());
        nords.alistar(not1);
        nords.alistar(not2);
        assertFalse(not1.equals(not2));
        assertTrue(nords.buscar("El Huervo").equals(not1));
    }
    
    @Test
    public void batalhaoEspecialDeElfosNaoRecebeElfosQueNaoSejamElfosVerdesOuElfosNoturnos() {
        BatalhaoEspecialDeElfos nords = new BatalhaoEspecialDeElfos();
        nords.alistar(new Elfo("Melita"));
        nords.alistar(new ElfoVerde("Café Pelé"));
        nords.alistar(new ElfoNoturno("Café do Mercado"));
        assertNull(nords.buscar("Melita"));
        assertEquals(new ElfoVerde("Café Pelé"), nords.buscar("Café Pelé"));
        assertEquals(new ElfoNoturno("Café do Mercado"), nords.buscar("Café do Mercado"));
    }
    
    @Test
    public void batalhaoEspecialDeElfosRetornaListaComUmElfoMorto() {
        ElfoNoturno elfo1 = new ElfoNoturno("Renato Aragão", 1000);
        for(int i = 0; i <= 200; i++){
            elfo1.atirarFlecha(new Dwarf());
        }
        ElfoVerde elfo2 = new ElfoVerde("Didi Mocó");
        BatalhaoEspecialDeElfos elfada = new BatalhaoEspecialDeElfos();
        elfada.alistar(elfo1);
        elfada.alistar(elfo2);
        ArrayList<Elfo> lista = elfada.buscar(Status.MORTO);
        assertEquals(Status.MORTO, elfo1.getStatus());
        assertEquals(1, lista.size());
        assertTrue(lista.get(0).getNome().equals("Renato Aragão"));
    }
    
    @Test
    public void batalhaoEspecialDeElfosRetornaListaComDoisElfosVivos() {
        ElfoNoturno elfo1 = new ElfoNoturno("Renato Aragão", 1000);
        for(int i = 0; i <= 200; i++){
            elfo1.atirarFlecha(new Dwarf());
        }
        ElfoVerde elfo2 = new ElfoVerde("Didi Mocó");
        ElfoVerde elfo3 = new ElfoVerde("Spongebob Squarepants");
        ElfoVerde elfo4 = new ElfoVerde("Didi Mocó");
        BatalhaoEspecialDeElfos elfada = new BatalhaoEspecialDeElfos();
        elfada.alistar(elfo1);
        elfada.alistar(elfo2);
        elfada.alistar(elfo3);
        elfada.alistar(elfo4);
        ArrayList<Elfo> lista = elfada.buscar(Status.VIVO);
        assertEquals(3, lista.size());
        assertTrue(lista.get(0).getNome().equals("Didi Mocó"));
        assertTrue(lista.get(1).getNome().equals("Didi Mocó"));
        assertTrue(lista.get(2).getNome().equals("Spongebob Squarepants"));
    }
    
    @Test
    public void alistarUmElfoVivoEDepoisMatalo() {
        ElfoNoturno elfo1 = new ElfoNoturno("Renato Aragão", 1000);
        BatalhaoEspecialDeElfos elfada = new BatalhaoEspecialDeElfos();
        elfada.alistar(elfo1);
        elfada.alistar(new ElfoVerde("Comichão"));
        for(int i = 0; i <= 200; i++){
            elfo1.atirarFlecha(new Dwarf());
        }
        assertEquals(1, elfada.buscar(Status.VIVO).size());
    }
    
    @After
    // Executa após cada um dos testes
    public void tearDown() {
        System.gc();
    }
}
