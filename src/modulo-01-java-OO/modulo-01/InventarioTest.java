

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
    
    @Test
    public void inventarioDescricoesAdagaEscudoBracelete() {
        // Arrange
        Inventario inv = new Inventario();
        inv.adicionarItem(new Item("Adaga", 1));
        inv.adicionarItem(new Item("Escudo", 1));
        inv.adicionarItem(new Item("Bracelete", 2));
        // Act & Assert
        assertEquals("Adaga,Escudo,Bracelete", inv.getDescricoesItens());
    }
    
    @Test
    public void inventarioDescricoesVestidosDe7Cores() {
        // Arrange
        Inventario inv = new Inventario();
        inv.adicionarItem(new Item("Vestido amarelo", 1));
        inv.adicionarItem(new Item("Vestido vermelho", 1));
        inv.adicionarItem(new Item("Vestido azul", 1));
        inv.adicionarItem(new Item("Vestido rosa", 1));
        inv.adicionarItem(new Item("Vestido marrom", 1));
        inv.adicionarItem(new Item("Vestido verde", 1));
        inv.adicionarItem(new Item("Vestido fúcsia", 1));
        // Act & Assert
        assertEquals("Vestido amarelo,Vestido vermelho,Vestido azul,Vestido rosa,Vestido marrom," +
            "Vestido verde,Vestido fúcsia", inv.getDescricoesItens());
    }
}
