
import static org.junit.Assert.*;
import org.junit.After;
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
        elfo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
        elfo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
        elfo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
        // Assert
        assertEquals(39, elfo.getFlecha().getQuantidade());
        assertEquals(3, elfo.getExp());
    }

    @Test
    public void elfoAtira42Flechas() {
        Elfo elfo = new Elfo("Hound");
        // Act
        for(int i = 0; i < 42; i++)
            elfo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
        assertEquals(42, elfo.getExp());
    }

    @Test
    public void elfoNaoDeveFlechas() {
        // Act
        Elfo elfo = new Elfo("Jonas");
        for(int i = 0; i < 100; i++)
            elfo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
        // Assert
        assertEquals(0, elfo.getFlecha().getQuantidade());
        assertEquals(42, elfo.getExp());
    }

    @Test
    public void elfoAtiraFlechaEmDwarf() {
        // Act
        Elfo elfo = new Elfo("Elrond");
        Dwarf dwarf = new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1));
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
            leo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
        // Assert
        assertEquals("Leônidas possui 27 flechas e 15 níveis de experiência.", leo.toString());
    }

    @Test
    public void toStringDeElfoAposAtirar60Flechas() {
        // Arrange
        Elfo leo = new Elfo("Leônidas");
        // Act
        for(int i = 0; i < 60; i++)
            leo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
        // Assert
        assertEquals("Leônidas possui 0 flechas e 42 níveis de experiência.", leo.toString());
    }

    @Test
    public void toStringDeElfoAposAtirar1Flecha() {
        // Arrange
        Elfo leo = new Elfo("Leônidas");
        // Act
        leo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
        // Assert
        assertEquals("Leônidas possui 41 flechas e 1 nível de experiência.", leo.toString());
    }
    
    @Test
    public void toStringDeElfoAposAtirar41Flechas() {
        // Arrange
        Elfo leo = new Elfo("Leônidas");
        // Act
        for(int i = 0; i < 41; i++)
            leo.atirarFlecha(new Dwarf("Coringa", new DataTerceiraEra(1, 1, 1)));
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
    
    @Test
    public void elfoNasceVivo() {
        // Arrange & Act
        Elfo elfo = new Elfo("Chico Buarque");
        // Assert
        assertEquals(Status.VIVO, elfo.getStatus());
    }
    
    @Test
    public void elfoRecebeItensEspadaEspadaEMachado() {
        Elfo elfo = new Elfo("Legolas");
        Item espada = new Item("Espada", 1);
        Item machado = new Item("Machado", 1);
        elfo.adicionarItem(espada);
        elfo.adicionarItem(machado);
        assertTrue(elfo.getInventario().getLista().contains(espada));
        assertTrue(elfo.getInventario().getLista().contains(machado));
    }
    
    @Test
    public void elfoRecebeItensEspadaEspadaEMachadoEPerdeEspada() {
        Elfo elfo = new Elfo("Legolas");
        Item espada = new Item("Espada", 1);
        Item machado = new Item("Machado", 1);
        elfo.adicionarItem(espada);
        elfo.adicionarItem(machado);
        elfo.perderItem(espada);
        assertFalse(elfo.getInventario().getLista().contains(espada));
        assertTrue(elfo.getInventario().getLista().contains(machado));
    }
    
    @Test
    public void elfoNasceCom100DeHp() {
        Elfo elfo = new Elfo("Pablo Escobar");
        assertEquals(100, elfo.getHp(), 0.01);
    }
    
    @Test
    public void contadorDeElfosNascidosIgualAoDaClasse() {
        new Elfo("");
        new Elfo("");
        assertEquals(2, Elfo.getContaElfos());
    }
    
    @After
    // Executa após cada um dos testes
    public void tearDown() {
        System.gc();
    }
}
