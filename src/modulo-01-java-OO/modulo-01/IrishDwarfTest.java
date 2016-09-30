

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IrishDwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IrishDwarfTest
{   
    @Test
    public void irishDwarfPossuiNumeroDaSorte101() {
        // Arrange
        IrishDwarf youtuber = new IrishDwarf("Pedro Pedroso", new DataTerceiraEra(31, 1, 2713));
        // Act & Assert
        assertEquals(101.0, youtuber.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void irishDwarfPossuiNumeroDaSorteMenos3333() {
        // Arrange
        IrishDwarf jamelao = new IrishDwarf("Jamelão", new DataTerceiraEra(2, 2, 2000));
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        // Act & Assert
        assertEquals(-3333.0, jamelao.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void irishDwarfSeixasPossuiNumeroDaSorte33() {
        // Arrange
        IrishDwarf joker = new IrishDwarf("Seixas", new DataTerceiraEra(14, 8, 1967));
        // Act & Assert
        assertEquals(33.0, joker.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void irishDwarfMeirelesPossuiNumeroDaSorte33() {
        // Arrange
        IrishDwarf joker = new IrishDwarf("Meireles", new DataTerceiraEra(14, 8, 1967));
        // Act & Assert
        assertEquals(33.0, joker.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void irishDwarfSucedeAoTentarSorteMenos3333() {
        // Arrange
        IrishDwarf jamelao = new IrishDwarf("Jamelão", new DataTerceiraEra(2, 2, 2000));
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        jamelao.adicionarItem(new Item("Melão", 10));
        jamelao.adicionarItem(new Item("Melão", 11));
        jamelao.adicionarItem(new Item("Melão", 12));
        // Act
        jamelao.tentarSorte();
        // Assert
        assertEquals(55010, jamelao.getInventario().getLista().get(0).getQuantidade());
        assertEquals(66011, jamelao.getInventario().getLista().get(1).getQuantidade());
        assertEquals(78012, jamelao.getInventario().getLista().get(2).getQuantidade());
    }
    
    @Test
    public void irishDwarfSeixasNaoSucedeAoTentarSorte33() {
        // Arrange
        IrishDwarf joker = new IrishDwarf("Seixas", new DataTerceiraEra(14, 8, 1967));
        joker.adicionarItem(new Item("Violão", 1));
        joker.adicionarItem(new Item("Amigo Pedro", 1));
        // Act
        joker.tentarSorte();
        // Assert
        assertEquals(1, joker.getInventario().getLista().get(0).getQuantidade());
        assertEquals(1, joker.getInventario().getLista().get(1).getQuantidade());
    }
    
    @Test
    public void irishDwarfNaoSucedeAoTentarSorte101() {
        // Arrange
        IrishDwarf youtuber = new IrishDwarf("Pedro Pedroso", new DataTerceiraEra(31, 1, 2713));
        youtuber.adicionarItem(new Item("Peteca", 666));
        // Act
        youtuber.tentarSorte();
        // Assert
        assertEquals(666, youtuber.getInventario().getLista().get(0).getQuantidade());
    }
}
