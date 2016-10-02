
import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HobbitContadorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HobbitContadorTest
{
    @Test
    public void hobbitContadorDiferencaCalculada840() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);
        assertEquals(840, diferenca);
    }

    @Test
    public void hobbitContadorDiferencaCalculada1680() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        int diferenca = new HobbitContador().calcularDiferenca(arrayDePares);
        assertEquals(1680, diferenca);
    }

    @Test
    public void hobbitContadorDiferencaCalculadaEmArrayVazio() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        int diferenca = new HobbitContador().calcularDiferenca(arrayDePares);
        assertEquals(0, diferenca);
    }

    @Test
    public void hobbitContadorDiferencaCalculadaEmArrayComParesZerados() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 10)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(10, 0)));
        int diferenca = new HobbitContador().calcularDiferenca(arrayDePares);
        assertEquals(0, diferenca);
    }
}
