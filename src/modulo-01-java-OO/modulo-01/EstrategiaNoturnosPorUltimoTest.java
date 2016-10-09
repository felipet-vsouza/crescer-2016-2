
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EstrategiaNoturnosPorUltimoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaNoturnosPorUltimoTest
{
    
    
    @Test
    public void ordemDeAtaqueComElfosVerdesNaFrenteEElfosNoturnosAtras() throws NaoPodeAlistarException {
        EstrategiaNoturnosPorUltimo elfada = new EstrategiaNoturnosPorUltimo();
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoNoturno("Leonidas"));
        lista.add(new ElfoNoturno("Ricadinho"));
        lista.add(new ElfoVerde("Rycharlison"));
        lista.add(new ElfoNoturno("Cláudio"));
        lista.add(new ElfoVerde("Café"));
        lista.add(new ElfoVerde("Acab"));
        List<Elfo> listaRet = elfada.getOrdemDeAtaque(lista, null);
        assertTrue(listaRet.get(0) instanceof ElfoVerde);
        assertTrue(listaRet.get(1) instanceof ElfoVerde);
        assertTrue(listaRet.get(2) instanceof ElfoVerde);
        assertTrue(listaRet.get(3) instanceof ElfoNoturno);
        assertTrue(listaRet.get(4) instanceof ElfoNoturno);
        assertTrue(listaRet.get(5) instanceof ElfoNoturno);
    }
    
    @Test
    public void ordenarAtaqueComContingenteVazio() throws NaoPodeAlistarException {
        EstrategiaNoturnosPorUltimo elfada = new EstrategiaNoturnosPorUltimo();
        ArrayList<Elfo> lista = new ArrayList<>();
        assertEquals(0, lista.size());
    }
    
    @Test
    public void ordenarAtaqueApenasComElfosNoturnos() throws NaoPodeAlistarException {
        EstrategiaNoturnosPorUltimo elfada = new EstrategiaNoturnosPorUltimo();
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoNoturno("Leonidas"));
        lista.add(new ElfoNoturno("Ricadinho"));
        lista.add(new ElfoNoturno("Rycharlison"));
        lista.add(new ElfoNoturno("Cláudio"));
        lista.add(new ElfoNoturno("Café"));
        lista.add(new ElfoNoturno("Acab"));
        List<Elfo> listaRet = elfada.getOrdemDeAtaque(lista, null);
        assertTrue(listaRet.get(0) instanceof ElfoNoturno);
        assertTrue(listaRet.get(1) instanceof ElfoNoturno);
        assertTrue(listaRet.get(2) instanceof ElfoNoturno);
        assertTrue(listaRet.get(3) instanceof ElfoNoturno);
        assertTrue(listaRet.get(4) instanceof ElfoNoturno);
        assertTrue(listaRet.get(5) instanceof ElfoNoturno);
    }
}
