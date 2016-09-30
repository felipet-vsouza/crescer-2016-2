

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InventarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InventarioTest
{
    @Test
    public void inventarioAdiciona2Itens() {
        // Arrange
        Inventario inv = new Inventario();
        // Act
        inv.adicionarItem(new Item("Garrafa", 1));
        inv.adicionarItem(new Item("Pedaço de pano", 1));
        // Assert
        assertEquals(2, inv.getLista().size());
    }
    
    @Test
    public void inventarioRemove1Item() {
        // Arrange
        Inventario inv = new Inventario();
        Item item = new Item("Garrafa", 1);
        inv.adicionarItem(item);
        // Act
        inv.removerItem(item);
        // Assert
        assertTrue(inv.getLista().isEmpty());
    }
}
