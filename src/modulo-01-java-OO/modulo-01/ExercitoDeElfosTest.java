import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
    public void exercitoDeElfosAlistaTresElfosDeCadaRaca() throws NaoPodeAlistarException {
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("Daisuke", 8), 
            not3 = new ElfoNoturno("Helmet", 22);
        ElfoVerde ver1 = new ElfoVerde("Dylan", 1), ver2 = new ElfoVerde("Corrina", 1), 
            ver3 = new ElfoVerde("Woman from the north country side", 1);
        ExercitoDeElfos nords = new ExercitoDeElfos();
        nords.alistar(not1);
        nords.alistar(not2);
        nords.alistar(not3);
        nords.alistar(ver1);
        nords.alistar(ver2);
        nords.alistar(ver3);
        assertTrue(contem(nords.getContingente(), new ElfoNoturno("El Huervo", 13)));
        assertTrue(contem(nords.getContingente(), new ElfoNoturno("Daisuke", 8)));
        assertTrue(contem(nords.getContingente(), new ElfoNoturno("Helmet", 22)));
        assertTrue(contem(nords.getContingente(), new ElfoVerde("Dylan", 1)));
        assertTrue(contem(nords.getContingente(), new ElfoVerde("Corrina", 1)));
        assertTrue(contem(nords.getContingente(), new ElfoVerde("Woman from the north country side", 1)));
    }
    
    @Test
    public void exercitoDeElfosAlistaTresElfosDeCadaRacaEBuscaElHuervo() throws NaoPodeAlistarException {
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("Daisuke", 8), 
            not3 = new ElfoNoturno("Helmet", 22);
        ElfoVerde ver1 = new ElfoVerde("Dylan", 1), ver2 = new ElfoVerde("Corrina", 1), 
            ver3 = new ElfoVerde("Woman from the north country side", 1);
        ExercitoDeElfos nords = new ExercitoDeElfos();
        nords.alistar(not1);
        nords.alistar(not2);
        nords.alistar(not3);
        nords.alistar(ver1);
        nords.alistar(ver2);
        nords.alistar(ver3);
        assertEquals(new ElfoNoturno("El Huervo", 13), nords.buscar("El Huervo"));
    }
    
    @Test
    public void exercitoDeElfosBuscarElfoEmContingenteVazio() throws NaoPodeAlistarException {
        ExercitoDeElfos nords = new ExercitoDeElfos();
        assertNull(nords.buscar("El Huervo"));
    }
    
    @Test
    public void exercitoDeElfosBuscarElfoComNomeDuplicadoEReceberOPrimeiro() throws NaoPodeAlistarException  {
        ExercitoDeElfos nords = new ExercitoDeElfos();
        ElfoNoturno not1 = new ElfoNoturno("El Huervo", 13), not2 = new ElfoNoturno("El Huervo", 13);
        not1.atirarFlecha(new Dwarf());
        not1.atirarFlecha(new Dwarf());
        nords.alistar(not1);
        nords.alistar(not2);
        assertFalse(not1.equals(not2));
        assertTrue(nords.buscar("El Huervo").equals(not1));
    }
    
    @Test(expected=NaoPodeAlistarException.class)
    public void exercitoDeElfosNaoRecebeElfosQueNaoSejamElfosVerdesOuElfosNoturnos() throws NaoPodeAlistarException {
        ExercitoDeElfos nords = new ExercitoDeElfos();
        nords.alistar(new Elfo("Melita"));
        nords.alistar(new ElfoVerde("Café Pelé"));
        nords.alistar(new ElfoNoturno("Café do Mercado"));
        assertNull(nords.buscar("Melita"));
        assertEquals(new ElfoVerde("Café Pelé"), nords.buscar("Café Pelé"));
        assertEquals(new ElfoNoturno("Café do Mercado"), nords.buscar("Café do Mercado"));
    }
    
    @Test
    public void exercitoDeElfosRetornaListaComUmElfoMorto() throws NaoPodeAlistarException {
        ElfoNoturno elfo1 = new ElfoNoturno("Renato Aragão", 1000);
        for(int i = 0; i <= 200; i++){
            elfo1.atirarFlecha(new Dwarf());
        }
        ElfoVerde elfo2 = new ElfoVerde("Didi Mocó");
        ExercitoDeElfos elfada = new ExercitoDeElfos();
        elfada.alistar(elfo1);
        elfada.alistar(elfo2);
        ArrayList<Elfo> lista = elfada.buscar(Status.MORTO);
        assertEquals(Status.MORTO, elfo1.getStatus());
        assertEquals(1, lista.size());
        assertTrue(lista.get(0).getNome().equals("Renato Aragão"));
    }
    
    @Test
    public void exercitoDeElfosRetornaListaComDoisElfosVivos() throws NaoPodeAlistarException {
        ElfoNoturno elfo1 = new ElfoNoturno("Renato Aragão", 1000);
        for(int i = 0; i <= 200; i++){
            elfo1.atirarFlecha(new Dwarf());
        }
        ElfoVerde elfo2 = new ElfoVerde("Didi Mocó");
        ElfoVerde elfo3 = new ElfoVerde("Spongebob Squarepants");
        ExercitoDeElfos elfada = new ExercitoDeElfos();
        elfada.alistar(elfo1);
        elfada.alistar(elfo2);
        elfada.alistar(elfo3);
        ArrayList<Elfo> lista = elfada.buscar(Status.VIVO);
        assertEquals(2, lista.size());
        assertTrue(lista.get(0).getNome().equals("Didi Mocó"));
        assertTrue(lista.get(1).getNome().equals("Spongebob Squarepants"));
    }
    
    @Test
    public void ordemDeAtaqueComElfosVerdesNaFrenteEElfosNoturnosAtras() throws NaoPodeAlistarException {
        ExercitoDeElfos elfada = new ExercitoDeElfos();
        elfada.alistar(new ElfoNoturno("Leonidas"));
        elfada.alistar(new ElfoNoturno("Ricadinho"));
        elfada.alistar(new ElfoVerde("Rycharlison"));
        elfada.alistar(new ElfoNoturno("Cláudio"));
        elfada.alistar(new ElfoVerde("Café"));
        elfada.alistar(new ElfoVerde("Acab"));
        List<Elfo> lista = elfada.getOrdemDeAtaque(Arrays.asList(elfada.getContingente()), null);
        assertTrue(lista.get(0) instanceof ElfoVerde);
        assertTrue(lista.get(1) instanceof ElfoVerde);
        assertTrue(lista.get(2) instanceof ElfoVerde);
        assertTrue(lista.get(3) instanceof ElfoNoturno);
        assertTrue(lista.get(4) instanceof ElfoNoturno);
        assertTrue(lista.get(5) instanceof ElfoNoturno);
    }
    
    @Test
    public void ordenarAtaqueComContingenteVazio() throws NaoPodeAlistarException {
        ExercitoDeElfos elfada = new ExercitoDeElfos();
        List<Elfo> lista = elfada.getOrdemDeAtaque(Arrays.asList(elfada.getContingente()), null);
        assertEquals(0, lista.size());
    }
    
    @Test
    public void ordenarAtaqueApenasComElfosNoturnos() throws NaoPodeAlistarException {
        ExercitoDeElfos elfada = new ExercitoDeElfos();
        elfada.alistar(new ElfoNoturno("Leonidas"));
        elfada.alistar(new ElfoNoturno("Ricadinho"));
        elfada.alistar(new ElfoNoturno("Rycharlison"));
        elfada.alistar(new ElfoNoturno("Cláudio"));
        elfada.alistar(new ElfoNoturno("Café"));
        elfada.alistar(new ElfoNoturno("Acab"));
        List<Elfo> lista = elfada.getOrdemDeAtaque(Arrays.asList(elfada.getContingente()), null);
        assertTrue(lista.get(0) instanceof ElfoNoturno);
        assertTrue(lista.get(1) instanceof ElfoNoturno);
        assertTrue(lista.get(2) instanceof ElfoNoturno);
        assertTrue(lista.get(3) instanceof ElfoNoturno);
        assertTrue(lista.get(4) instanceof ElfoNoturno);
        assertTrue(lista.get(5) instanceof ElfoNoturno);
    }
    
    @After
    // Executa após cada um dos testes
    public void tearDown() {
        System.gc();
    }
    
    private boolean contem(Elfo[] lista, Elfo elfo) {
        for(Elfo buscado : lista){
            if(buscado.equals(elfo)){
                return true;
            }
        }
        return false;
    }
}
