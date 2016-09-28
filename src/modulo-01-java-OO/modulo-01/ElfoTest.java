

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
    public void elfoNasceAtiraFlechas() {
        // Act
        Elfo elfo = new Elfo("Gabe Newell");
        Elfo elfo2 = new Elfo("Scorcese");
        elfo2.atirarFlecha();
        elfo2.atirarFlecha();
        elfo2.atirarFlecha();
        Elfo elfo3 = new Elfo("Hound");
        for(int i = 0; i < 42; i++)
            elfo3.atirarFlecha();
        // Assert
        assertEquals(42, elfo.getFlecha().getQuantidade());
        assertEquals(39, elfo2.getFlecha().getQuantidade());
        assertEquals(0, elfo3.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoNaoDeveFlechas() {
        // Act
        Elfo elfo = new Elfo("Jonas");
        for(int i = 0; i < 100; i++)
            elfo.atirarFlecha();
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
    }
    
    @Test
    public void elfoAtiraFlechaEmDwarf() {
        // Act
        Elfo elfo = new Elfo("Elrond");
        Dwarf dwarf = new Dwarf("Gimli");
        elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(41, elfo.getFlecha().getQuantidade());
    }
}
