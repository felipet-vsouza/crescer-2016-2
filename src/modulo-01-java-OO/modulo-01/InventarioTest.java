

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
        Item item0 = inv.getLista().get(0);
        Item item1 = inv.getLista().get(1);
        assertEquals("Garrafa", item0.getDescricao());
        assertEquals("Pedaço de pano", item1.getDescricao());
        assertEquals(1, item0.getQuantidade());
        assertEquals(1, item1.getQuantidade());
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
    
    @Test
    public void inventarioDescricoesVazio() {
        // Arrange
        Inventario inventario = new Inventario();
        // Act & Assert
        assertEquals("", inventario.getDescricoesItens());
    }
    
    @Test
    public void inventarioItemMaisPopularSaoSessentaColheres() {
        // Arrange
        Inventario inv = new Inventario();
        inv.adicionarItem(new Item("Peneira", 20));
        inv.adicionarItem(new Item("Martelo", 2));
        inv.adicionarItem(new Item("Concha", 28));
        inv.adicionarItem(new Item("Pente", 59));
        inv.adicionarItem(new Item("Ponte", 1));
        inv.adicionarItem(new Item("Pá", 60));
        inv.adicionarItem(new Item("Molho barbecue", 33));
        inv.adicionarItem(new Item("Club Social", 6));
        // Act
        Item maisPop = inv.getItemMaisPopular();
        // Assert
        assertEquals("Pá", maisPop.getDescricao());
        assertEquals(60, maisPop.getQuantidade());
    }
    
    @Test
    public void inventarioItemMaisPopularEhNullNoInventarioVazio() {
        // Arrange
        Inventario inv = new Inventario();
        // Act & Assert
        assertEquals(null, inv.getItemMaisPopular());
    }
    
    @Test
    public void inventarioItemMaisPopularSaoDozePeixesCoalho() {
        // Arrange
        Inventario inv = new Inventario();
        inv.adicionarItem(new Item("Peixe coalho", 12));
        inv.adicionarItem(new Item("Martelo", 12));
        inv.adicionarItem(new Item("Concha", 12));
        inv.adicionarItem(new Item("Pente", 12));
        inv.adicionarItem(new Item("Ponte", 12));
        inv.adicionarItem(new Item("Pá", 12));
        inv.adicionarItem(new Item("Molho barbecue", 12));
        inv.adicionarItem(new Item("Club Social", 12));
        // Act
        Item maisPop = inv.getItemMaisPopular();
        // Assert
        assertEquals("Peixe coalho", maisPop.getDescricao());
        assertEquals(12, maisPop.getQuantidade());
    }
    
    @Test
    public void inventarioRecebe2016DeCadaItem() {
        Inventario inv = new Inventario();
        inv.adicionarItem(new Item("Perna", 11));
        inv.adicionarItem(new Item("Contrato", 4));
        inv.aumentarUnidadesDosItens(2016);
        assertEquals(2027, inv.getLista().get(0).getQuantidade());
        assertEquals(2020, inv.getLista().get(1).getQuantidade());
    }
}
