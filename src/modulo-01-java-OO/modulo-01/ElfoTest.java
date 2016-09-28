
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
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        elfo.atirarFlecha(new Dwarf());
        // Assert
        assertEquals(39, elfo.getFlecha().getQuantidade());
        assertEquals(3, elfo.getExp());
    }

    @Test
    public void elfoAtira42Flechas() {
        Elfo elfo = new Elfo("Hound");
        // Act
        for(int i = 0; i < 42; i++)
            elfo.atirarFlecha(new Dwarf());
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
        assertEquals(42, elfo.getExp());
    }

    @Test
    public void elfoNaoDeveFlechas() {
        // Act
        Elfo elfo = new Elfo("Jonas");
        for(int i = 0; i < 100; i++)
            elfo.atirarFlecha(new Dwarf());
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

    @Test
    public void toStringDeElfoAoNascer() {
        // Arrange
        Elfo leo = new Elfo("Leônidas");
        // Act & Assert
        assertEquals("Leônidas possui 42 flechas e 0 níveis de experiência.", leo.toString());
    }

    @Test
    public void toStringDeElfoAposAtirar15Flechas() {
        // Arrange
        Elfo leo = new Elfo("Leônidas");
        // Act
        for(int i = 0; i < 15; i++)
            leo.atirarFlecha(new Dwarf());
        // Assert
        assertEquals("Leônidas possui 27 flechas e 15 níveis de experiência.", leo.toString());
    }

    @Test
    public void toStringDeElfoAposAtirar60Flechas() {
        // Arrange
        Elfo leo = new Elfo("Leônidas");
        // Act
        for(int i = 0; i < 60; i++)
            leo.atirarFlecha(new Dwarf());
        // Assert
        assertEquals("Leônidas possui 0 flechas e 42 níveis de experiência.", leo.toString());
    }

    @Test
    public void toStringDeElfoAposAtirar1Flecha() {
        // Arrange
        Elfo leo = new Elfo("Leônidas");
        // Act
        leo.atirarFlecha(new Dwarf());
        // Assert
        assertEquals("Leônidas possui 41 flechas e 1 nível de experiência.", leo.toString());
    }
    
    @Test
    public void toStringDeElfoAposAtirar41Flechas() {
        // Arrange
        Elfo leo = new Elfo("Leônidas");
        // Act
        for(int i = 0; i < 41; i++)
            leo.atirarFlecha(new Dwarf());
        // Assert
        assertEquals("Leônidas possui 1 flecha e 41 níveis de experiência.", leo.toString());
    }

    @Test
    public void elfoNasceCom100000Flechas() {
        // Arrange & Act
        Elfo elfo = new Elfo("João Carlos", 100000);
        // Assert
        assertEquals("João Carlos", elfo.getNome());
        assertEquals(100000, elfo.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNasceComMenos30Flechas() {
        // Arrange & Act
        Elfo elfo = new Elfo("Gloin", -30);
        // Assert
        assertEquals("Gloin", elfo.getNome());
        assertEquals(42, elfo.getFlecha().getQuantidade());
    }

    @Test
    public void elfoNasceSemFlechas() {
        // Arrange & Act
        Elfo elfo = new Elfo("Dovakhin", 0);
        // Assert
        assertEquals("Dovakhin", elfo.getNome());
        assertEquals(0, elfo.getFlecha().getQuantidade());
    }
}
