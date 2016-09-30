

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
        Dwarf dwarf = new Dwarf("Jonas", new DataTerceiraEra(1, 1, 1));
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
        Dwarf dwarf = new Dwarf("Jonas", new DataTerceiraEra(1, 1, 1));
        // Act
        dwarf.recebeDano(200);
        // Assert
        assertEquals(0, dwarf.getHp());
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
    
    @Test
    public void dwarfPossuiNumeroDaSorte101() {
        // Arrange
        Dwarf youtuber = new Dwarf("Pedro Pedroso", new DataTerceiraEra(31, 1, 2713));
        // Act & Assert
        assertEquals(101.0, youtuber.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void dwarfPossuiNumeroDaSorteMenos3333() {
        // Arrange
        Dwarf jamelao = new Dwarf("Jamelão", new DataTerceiraEra(2, 2, 2000));
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        // Act & Assert
        assertEquals(-3333.0, jamelao.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void dwarfSeixasPossuiNumeroDaSorte33() {
        // Arrange
        Dwarf joker = new Dwarf("Seixas", new DataTerceiraEra(14, 8, 1967));
        // Act & Assert
        assertEquals(33.0, joker.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void dwarfMeirelesPossuiNumeroDaSorte33() {
        // Arrange
        Dwarf joker = new Dwarf("Meireles", new DataTerceiraEra(14, 8, 1967));
        // Act & Assert
        assertEquals(33.0, joker.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void dwarfRecebeDanoNormalmente() {
        // Arrange
        Dwarf ronaldo = new Dwarf("Ronaldo", new DataTerceiraEra(1, 1, 1));
        // Act
        ronaldo.recebeDano(10);
        // Assert
        assertEquals(0, ronaldo.getExp());
        assertEquals(100, ronaldo.getHp());
    }
    
    @Test
    public void dwarfRecebe2ExpENaoReceneDano() {
        // Arrange
        Dwarf jamelao = new Dwarf("Jamelão", new DataTerceiraEra(2, 2, 2000));
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        // Act
        jamelao.recebeDano(10);
        // Assert
        assertEquals(2, jamelao.getExp());
        assertEquals(90, jamelao.getHp());
    }
    
    @Test
    public void dwarfMeirelesNaoRecebeDanoNemExp() {
        // Arrange
        Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(14, 8, 1967));
        // Act
        meireles.recebeDano(10);
        // Assert
        assertEquals(0, meireles.getExp());
        assertEquals(110, meireles.getHp());
    }
    
    @Test
    public void dwarfNasceVivo() {
        assertEquals(Status.VIVO, new Dwarf("Gilson", new DataTerceiraEra(1, 1, 1)).getStatus());
    }
    
    @Test
    public void dwarfContinuaVivoAposReceber50Dano() {
        // Arrange
        Dwarf miletto = new Dwarf("Miletto", new DataTerceiraEra(1, 1, 1));
        // Act
        miletto.recebeDano(50);
        // Assert
        assertEquals(Status.VIVO, miletto.getStatus());
    }
    
    @Test
    public void dwarfPereceAposReceber110Dano() {
        // Arrange
        Dwarf kuririn = new Dwarf("Kuririn", new DataTerceiraEra(1, 1, 1));
        // Act
        kuririn.recebeDano(110);
        // Assert
        assertEquals(Status.MORTO, kuririn.getStatus());
    }
    
    @Test
    public void dwarfNaoDeveVidasAposReceber500Dano() {
        // Arrange
        Dwarf master = new Dwarf("Master", new DataTerceiraEra(1, 1, 1));
        // Act
        master.recebeDano(500);
        // Assert
        assertEquals(0, master.getHp());
    }
    
    @Test
    public void dwarfGanhaUmMachadoEUmaGarrafa() {
        // Arrange
        Dwarf master = new Dwarf();
        // Act
        master.adicionarItem(new Item("Machado", 1));
        master.adicionarItem(new Item("Garrafa", 2));
        // Assert
        assertEquals(2, master.getInventario().getLista().size());
    }
    
    @Test
    public void dwarfPerdeTresPentesECincoPetecas() {
        // Arrange
        Dwarf master = new Dwarf();
        Item pente = new Item("Pente", 3);
        Item peteca = new Item("Peteca", 5);
        master.adicionarItem(pente);
        master.adicionarItem(peteca);
        // Act
        master.perderItem(pente);
        master.perderItem(peteca);
        // Assert
        assertTrue(master.getInventario().getLista().isEmpty());
    }
    
    @Test
    public void dwarfNaoSucedeAoTentarSorte101() {
        // Arrange
        Dwarf youtuber = new Dwarf("Pedro Pedroso", new DataTerceiraEra(31, 1, 2713));
        youtuber.adicionarItem(new Item("PC Gamer", 4));
        youtuber.adicionarItem(new Item("Barrinha de cereal", 10000));
        // Act
        youtuber.tentarSorte();
        // Assert
        assertEquals(4, youtuber.getInventario().getLista().get(0).getQuantidade());
        assertEquals(10000, youtuber.getInventario().getLista().get(1).getQuantidade());
    }
    
    @Test
    public void dwarfSucedeAoTentarSorteMenos3333() {
        // Arrange
        Dwarf jamelao = new Dwarf("Jamelão", new DataTerceiraEra(2, 2, 2000));
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        jamelao.recebeDano(10);
        jamelao.adicionarItem(new Item("Melão", 12));
        jamelao.adicionarItem(new Item("Melão", 120));
        jamelao.adicionarItem(new Item("Melão", 1200));
        // Act
        jamelao.tentarSorte();
        // Assert
        assertEquals(1012, jamelao.getInventario().getLista().get(0).getQuantidade());
        assertEquals(1120, jamelao.getInventario().getLista().get(1).getQuantidade());
        assertEquals(2200, jamelao.getInventario().getLista().get(2).getQuantidade());
    }
    
    @Test
    public void dwarfSeixasNaoSucedeAoTentarSorte33() {
        // Arrange
        Dwarf joker = new Dwarf("Seixas", new DataTerceiraEra(14, 8, 1967));
        joker.adicionarItem(new Item("Violão", 1));
        joker.adicionarItem(new Item("Amigo Pedro", 1));
        // Act
        joker.tentarSorte();
        // Assert
        assertEquals(1, joker.getInventario().getLista().get(0).getQuantidade());
        assertEquals(1, joker.getInventario().getLista().get(1).getQuantidade());
    }
}
