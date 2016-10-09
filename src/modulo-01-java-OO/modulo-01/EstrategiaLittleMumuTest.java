
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EstrategiaLittleMumuTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaLittleMumuTest
{
    @Test
    public void ordenaAtaqueComUmElfoInaptoEQuatroAptos() {
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoNoturno("Noturno 1", 3));
        lista.add(new ElfoNoturno("Noturno 2", 12));
        lista.add(new ElfoVerde("Verde 1", 0));
        lista.add(new ElfoVerde("Verde 3", 40));
        lista.add(new ElfoVerde("Verde 3", 50));
        List<Elfo> listaRet = new EstrategiaLittleMumu().getOrdemDeAtaque(lista, null);
        assertEquals(1, listaRet.size());
    }
    
    @Test
    public void ordenaAtaqueComTresElfosInaptosEDozeAptos() {
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoNoturno("Noturno 1", 3));
        lista.add(new ElfoNoturno("Noturno 2", 12));
        lista.add(new ElfoVerde("Verde 1", 0));
        lista.add(new ElfoVerde("Verde 3", 40));
        lista.add(new ElfoVerde("Verde 3", 50));
        lista.add(new ElfoNoturno("Noturno 3", 3));
        lista.add(new ElfoNoturno("Noturno 4", 12));
        lista.add(new ElfoVerde("Verde 4", 0));
        lista.add(new ElfoVerde("Verde 5", 0));
        lista.add(new ElfoVerde("Verde 6", 50));
        lista.add(new ElfoVerde("Verde 7", 40));
        lista.add(new ElfoVerde("Verde 8", 50));
        lista.add(new ElfoVerde("Verde 9", 50));
        lista.add(new ElfoVerde("Verde 10", 40));
        lista.add(new ElfoVerde("Verde 11", 50));
        List<Elfo> listaRet = new EstrategiaLittleMumu().getOrdemDeAtaque(lista, null);
        assertEquals(3, listaRet.size());
    } 
    
    @Test
    public void ordenaAtaqueComContingenteVazio() {
        ArrayList<Elfo> lista = new ArrayList<>();
        List<Elfo> listaRet = new EstrategiaLittleMumu().getOrdemDeAtaque(lista, null);
        assertEquals(0, listaRet.size());
    }
    
    @Test
    public void ordenaAtaqueComTresElfosAptosEDozeInaptos() {
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoNoturno("Noturno 1", 0));
        lista.add(new ElfoNoturno("Noturno 2", 0));
        lista.add(new ElfoVerde("Verde 1", 0));
        lista.add(new ElfoVerde("Verde 3", 0));
        lista.add(new ElfoVerde("Verde 3", 0));
        lista.add(new ElfoNoturno("Noturno 3", 0));
        lista.add(new ElfoNoturno("Noturno 4", 0));
        lista.add(new ElfoVerde("Verde 4", 0));
        lista.add(new ElfoVerde("Verde 5", 0));
        lista.add(new ElfoVerde("Verde 6", 50));
        lista.add(new ElfoVerde("Verde 7", 0));
        lista.add(new ElfoVerde("Verde 8", 0));
        lista.add(new ElfoVerde("Verde 9", 50));
        lista.add(new ElfoVerde("Verde 10", 0));
        lista.add(new ElfoVerde("Verde 11", 50));
        List<Elfo> listaRet = new EstrategiaLittleMumu().getOrdemDeAtaque(lista, null);
        assertEquals(0, listaRet.size());
    } 
    
    @Test
    public void ordenaAtaqueComQuinzeElfosInaptosENenhumApto() {
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoNoturno("Noturno 1", 0));
        lista.add(new ElfoNoturno("Noturno 2", 0));
        lista.add(new ElfoVerde("Verde 1", 0));
        lista.add(new ElfoVerde("Verde 3", 0));
        lista.add(new ElfoVerde("Verde 3", 0));
        lista.add(new ElfoNoturno("Noturno 3", 0));
        lista.add(new ElfoNoturno("Noturno 4", 0));
        lista.add(new ElfoVerde("Verde 4", 0));
        lista.add(new ElfoVerde("Verde 5", 0));
        lista.add(new ElfoVerde("Verde 6", 0));
        lista.add(new ElfoVerde("Verde 7", 0));
        lista.add(new ElfoVerde("Verde 8", 0));
        lista.add(new ElfoVerde("Verde 9", 0));
        lista.add(new ElfoVerde("Verde 10", 0));
        lista.add(new ElfoVerde("Verde 11", 0));
        List<Elfo> listaRet = new EstrategiaLittleMumu().getOrdemDeAtaque(lista, null);
        assertEquals(0, listaRet.size());
    } 
}
