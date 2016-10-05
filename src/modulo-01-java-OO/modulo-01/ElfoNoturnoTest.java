

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoGanha9ExpAoAtirarTresFlechas() {
        ElfoNoturno elfo = new ElfoNoturno("Marcelo");
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        assertEquals(9, elfo.getExp());
    }
    
    @Test
    public void elfoNoturnoFicaCom87HpAoAtirarTresFlechas() {
        ElfoNoturno elfo = new ElfoNoturno("Marcelo");
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        assertEquals(85.7375, elfo.getHp(), 0.01);
    }
    
    @Test
    public void elfoNoturnoFicaCom95HpAoAtirarUmaFlecha() {
        ElfoNoturno elfo = new ElfoNoturno("Marcelo");
        elfo.atirarFlecha(new Dwarf());
        assertEquals(95, elfo.getHp(), 0.01);
    }
    
    @Test
    public void elfoNoturnoPodeMorrerAtirandoFlechas() {
        ElfoNoturno elfo = new ElfoNoturno("Marcelo", 91);
        while(!elfo.getStatus().equals(Status.MORTO)) {
            elfo.atirarFlecha(new Dwarf());
        }
        assertTrue(elfo.getStatus().equals(Status.MORTO));
    }
    
    @Test
    public void elfoNoturnoNaoGanhaExpAoAtirarFlechasQuandoNaoTemMaisFlechas() {
        ElfoNoturno elfo = new ElfoNoturno("Nenem", 1);
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        assertEquals(3, elfo.getExp());
    }
    
    @Test
    public void elfoNoturnoNaoPerdeVidaAoAtirarFlechasMesmoQuandoNaoTemMaisFlechas() {
        ElfoNoturno elfo = new ElfoNoturno("Elfo noturno", 1);
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        assertEquals(95, elfo.getHp(), 0.01);
    }
    
    @After
    // Executa após cada um dos testes
    public void tearDown() {
        System.gc();
    }
}
