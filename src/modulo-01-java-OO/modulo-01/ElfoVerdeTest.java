

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeGanhaDobroExpAoAtirarFlecha() {
        ElfoVerde elfoVerde = new ElfoVerde("Maçã Verde");
        elfoVerde.atirarFlecha(new Dwarf());
        elfoVerde.atirarFlecha(new Dwarf());
        elfoVerde.atirarFlecha(new Dwarf());
        assertEquals(6, elfoVerde.getExp());
    }
    
    @Test
    public void elfoVerdeNaoRecebeItensDiferentesDosPrevistos() {
        ElfoVerde elfoVerde = new ElfoVerde("Imp");
        Item espada = new Item("Espada Z", 1), pente = new Item("Pente de bigode", 1), 
            abajur = new Item("Abajur", 1);
        elfoVerde.adicionarItem(espada);
        elfoVerde.adicionarItem(pente);
        elfoVerde.adicionarItem(abajur);
        assertFalse(elfoVerde.getInventario().getLista().contains(espada));
        assertFalse(elfoVerde.getInventario().getLista().contains(pente));
        assertFalse(elfoVerde.getInventario().getLista().contains(abajur));
    }
    
    @Test
    public void elfoVerdeRecebeItensEspadaDeAcoValirianoEArcoEFlechaDeVidro() {
        ElfoVerde elfoVerde = new ElfoVerde("Imp");
        Item espada = new Item("Espada de aço valiriano", 1), 
            arco = new Item("Arco e Flecha de Vidro", 1);
        elfoVerde.adicionarItem(espada);
        elfoVerde.adicionarItem(arco);
        assertTrue(elfoVerde.getInventario().getLista().contains(espada));
        assertTrue(elfoVerde.getInventario().getLista().contains(arco));
    }
    
    @Test
    public void elfoVerdeNasceCom100Hp() {
        ElfoVerde elfo = new ElfoVerde("Pablo Escobar verde");
        assertEquals(100, elfo.getHp());
    }
    
    @Test
    public void elfoVerdeNaoGanhaExpQuandoNaoTemMaisFlechas() {
        ElfoVerde elfo = new ElfoVerde("Pepem", 1);
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        assertEquals(2, elfo.getExp());
    }
}
