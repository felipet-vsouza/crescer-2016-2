
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EstrategiaAtaqueIntercaladoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaAtaqueIntercaladoTest
{
    
    
    @Test(expected=ContingenteDesproporcionalException.class)
    public void ordenarAtaqueComContingenteDesproporcional() throws NaoPodeAlistarException, ContingenteDesproporcionalException {
        EstrategiaAtaqueIntercalado bat = new EstrategiaAtaqueIntercalado();
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoVerde("João"));
        lista.add(new ElfoVerde("João Pedro"));
        lista.add(new ElfoNoturno("Lester"));
        lista.add(new ElfoVerde("João Lucas"));
        lista.add(new ElfoVerde("João João"));
        bat.getOrdemDeAtaque(lista, null);
    }
    
    @Test
    public void ordenarAtaqueComDoisElfos() throws NaoPodeAlistarException, ContingenteDesproporcionalException {
        EstrategiaAtaqueIntercalado bat = new EstrategiaAtaqueIntercalado();
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoVerde("João"));
        lista.add(new ElfoNoturno("João Pedro"));
        List<Elfo> listRet = bat.getOrdemDeAtaque(lista, null);
        assertTrue(listRet.get(0) instanceof ElfoVerde);
        assertTrue(listRet.get(1) instanceof ElfoNoturno);
    }
    
    @Test
    public void ordenarAtaqueComDozeElfosComecandoPorElfoNoturno() throws NaoPodeAlistarException, ContingenteDesproporcionalException {
        EstrategiaAtaqueIntercalado bat = new EstrategiaAtaqueIntercalado();
        ArrayList<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoNoturno("João Pedro"));
        elfos.add(new ElfoVerde("João"));
        elfos.add(new ElfoVerde("João"));
        elfos.add(new ElfoVerde("João"));
        elfos.add(new ElfoVerde("João"));
        elfos.add(new ElfoNoturno("João Pedro"));
        elfos.add(new ElfoVerde("João"));
        elfos.add(new ElfoNoturno("João Pedro"));
        elfos.add(new ElfoVerde("João"));
        elfos.add(new ElfoNoturno("João Pedro"));
        elfos.add(new ElfoNoturno("João Pedro"));
        elfos.add(new ElfoNoturno("João Pedro"));
        List<Elfo> lista = bat.getOrdemDeAtaque(elfos, null);
        assertTrue(lista.get(0) instanceof ElfoNoturno);
        assertTrue(lista.get(1) instanceof ElfoVerde);
        assertTrue(lista.get(2) instanceof ElfoNoturno);
        assertTrue(lista.get(3) instanceof ElfoVerde);
        assertTrue(lista.get(4) instanceof ElfoNoturno);
        assertTrue(lista.get(5) instanceof ElfoVerde);
        assertTrue(lista.get(6) instanceof ElfoNoturno);
        assertTrue(lista.get(7) instanceof ElfoVerde);
        assertTrue(lista.get(8) instanceof ElfoNoturno);
        assertTrue(lista.get(9) instanceof ElfoVerde);
        assertTrue(lista.get(10) instanceof ElfoNoturno);
        assertTrue(lista.get(11) instanceof ElfoVerde);
    }
    
    @Test
    public void ordenarAtaqueComDozeElfosComecandoPorElfoVerde() throws NaoPodeAlistarException, ContingenteDesproporcionalException {
        EstrategiaAtaqueIntercalado bat = new EstrategiaAtaqueIntercalado();
        ArrayList<Elfo> lista = new ArrayList<>();
        lista.add(new ElfoVerde("João"));
        lista.add(new ElfoVerde("João"));
        lista.add(new ElfoVerde("João"));
        lista.add(new ElfoNoturno("João Pedro"));
        lista.add(new ElfoVerde("João"));
        lista.add(new ElfoNoturno("João Pedro"));
        lista.add(new ElfoVerde("João"));
        lista.add(new ElfoNoturno("João Pedro"));
        lista.add(new ElfoVerde("João"));
        lista.add(new ElfoNoturno("João Pedro"));
        lista.add(new ElfoNoturno("João Pedro"));
        lista.add(new ElfoNoturno("João Pedro"));
        List<Elfo> listaRet = bat.getOrdemDeAtaque(lista, null);
        assertTrue(listaRet.get(0) instanceof ElfoVerde);
        assertTrue(listaRet.get(1) instanceof ElfoNoturno);
        assertTrue(listaRet.get(2) instanceof ElfoVerde);
        assertTrue(listaRet.get(3) instanceof ElfoNoturno);
        assertTrue(listaRet.get(4) instanceof ElfoVerde);
        assertTrue(listaRet.get(5) instanceof ElfoNoturno);
        assertTrue(listaRet.get(6) instanceof ElfoVerde);
        assertTrue(listaRet.get(7) instanceof ElfoNoturno);
        assertTrue(listaRet.get(8) instanceof ElfoVerde);
        assertTrue(listaRet.get(9) instanceof ElfoNoturno);
        assertTrue(listaRet.get(10) instanceof ElfoVerde);
        assertTrue(listaRet.get(11) instanceof ElfoNoturno);
    }
}
