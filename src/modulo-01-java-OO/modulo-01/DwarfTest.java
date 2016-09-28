

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DwarfTest
{
    @Test
    public void dwarfNasceComNome(){
        // Arrange
        String nome = "Gimli";
        // Act
        Dwarf dwarf = new Dwarf(nome);
        // Assert
        assertEquals(nome, dwarf.getNome());
    }
    
    @Test
    public void dwarfNasceComHP(){
        // Act
        Dwarf dwarf = new Dwarf("Geraldo");
        // Assert
        assertEquals(110, dwarf.getHP());
    }
    
    @Test
    public void dwarfRecebeFlechada(){
        // Act
        Dwarf dwarf = new Dwarf("Hemingway");
        Elfo elfo = new Elfo("Fitzgerald");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(80, dwarf.getHP());
    }
}
