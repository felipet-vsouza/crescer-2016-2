

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
}
