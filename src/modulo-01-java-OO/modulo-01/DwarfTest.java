

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
    public void dwarfNasceComHP(){
        // Arrange & Act
        Dwarf dwarf = new Dwarf();
        // Assert
        assertEquals(110, dwarf.getHp());
    }
    
    @Test
    public void dwarfRecebeTresFlechadas(){
        // Act
        Dwarf dwarf = new Dwarf();
        Elfo elfo = new Elfo("Fitzgerald");
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        elfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(80, dwarf.getHp());
    }
    
    @Test
    public void dwarfRecebe200Dano() {
        // Arrange
        Dwarf dwarf = new Dwarf();
        // Act
        dwarf.recebeDano(200);
        // Assert
        assertEquals(-90, dwarf.getHp());
    }
    
    @Test
    public void dwarfNasceComNomeGimli() {
        // Arrange & Act
        Dwarf dwarf = new Dwarf("Gimli", new DataTerceiraEra(2, 10, 1993));
        // Assert
        assertEquals("Gimli", dwarf.getNome());
    }
    
    @Test
    public void dwarfPossuiDataNascimentoDia31Mes12Ano1004() {
        // Arrange & Act
        Dwarf pedrao = new Dwarf("Pedrão", new DataTerceiraEra(31, 12, 1004));
        // Assert
        assertEquals(31, pedrao.getDataNascimento().getDia());
        assertEquals(12, pedrao.getDataNascimento().getMes());
        assertEquals(1004, pedrao.getDataNascimento().getAno());
    }
}
