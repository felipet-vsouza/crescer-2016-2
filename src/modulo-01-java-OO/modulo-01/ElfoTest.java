

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  felipe.souza
 * @version 2016/09/27
 */
public class ElfoTest
{
    @Test
    public void elfoNasceComNome() {
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo bruceWayne = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, bruceWayne.getNome());
    }
    
    @Test
    public void elfoNasceComArco() {
        // Act
        Elfo elfo = new Elfo("Elrond");
        // Assert
        assertEquals("Arco", elfo.getArco().getDescricao());
        assertEquals(1, elfo.getArco().getQuantidade());
    }
    
    @Test
    public void elfoNasceComFlechas() {
        // Act
        Elfo elfo = new Elfo("Jeremias");
        // Assert
        assertEquals("Flechas", elfo.getFlecha().getDescricao());
        assertEquals(42, elfo.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoNaoAtiraFlechas() {
        // Arrange & Act
        Elfo elfo = new Elfo("Gabe Newell");
        // Assert
        assertEquals(42, elfo.getFlecha().getQuantidade());
        assertEquals(0, elfo.getExp());
    }
    
    @Test
    public void elfoAtiraTresFlechas() {
        // Arrange
        Elfo elfo = new Elfo("Scorcese");
        // Act
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        elfo.atirarFlecha();
        // Assert
        assertEquals(39, elfo.getFlecha().getQuantidade());
        assertEquals(3, elfo.getExp());
    }
    
    @Test
    public void elfoAtira42Flechas() {
        Elfo elfo = new Elfo("Hound");
        // Act
        for(int i = 0; i < 42; i++)
            elfo.atirarFlecha();
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
        assertEquals(42, elfo.getExp());
    }
    
    @Test
    public void elfoNaoDeveFlechas() {
        // Act
        Elfo elfo = new Elfo("Jonas");
        for(int i = 0; i < 100; i++)
            elfo.atirarFlecha();
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
        assertEquals(42, elfo.getExp());
    }
    
    @Test
    public void elfoAtiraFlechaEmDwarf() {
        // Act
        Elfo elfo = new Elfo("Elrond");
        Dwarf dwarf = new Dwarf();
        elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(41, elfo.getFlecha().getQuantidade());
    }
}
