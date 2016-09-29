

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DataTerceiraEraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DataTerceiraEraTest
{
    @Test
    public void dataTerceiraEraNasceComDia1Mes1Ano1() {
        // Arrange & Act
        DataTerceiraEra data = new DataTerceiraEra(1, 1, 1);
        // Assert
        assertEquals(1, data.getDia());
        assertEquals(1, data.getMes());
        assertEquals(1, data.getAno());
    }
    
    @Test
    public void dataTerceiraEraNasceComDia2Mes10Ano1222() {
        // Arrange & Act
        DataTerceiraEra data = new DataTerceiraEra(2, 10, 1222);
        // Assert
        assertEquals(2, data.getDia());
        assertEquals(10, data.getMes());
        assertEquals(1222, data.getAno());
    }
    
    
    @Test
    public void dataTerceiraEraNasceComDia1000Mes2000AnoMenos444() {
        // Arrange & Act
        DataTerceiraEra data = new DataTerceiraEra(1000, 2000, -444);
        // Assert
        assertEquals(1000, data.getDia());
        assertEquals(2000, data.getMes());
        assertEquals(-444, data.getAno());
    }
    
    @Test
    public void dataTerceiraEraAno3019NaoEhBissexto() {
        // Arrange
        DataTerceiraEra fimDaGuerraDoAnel = new DataTerceiraEra(1, 10, 3019);
        // Act & Assert
        assertFalse(fimDaGuerraDoAnel.ehBissexto());
    }
    
    @Test
    public void dataTerceiraEraAno2000EhBissexto() {
        // Arrange
        DataTerceiraEra fimDaGuerraDoAnel = new DataTerceiraEra(1, 1, 2000);
        // Act & Assert
        assertTrue(fimDaGuerraDoAnel.ehBissexto());
    }
}
