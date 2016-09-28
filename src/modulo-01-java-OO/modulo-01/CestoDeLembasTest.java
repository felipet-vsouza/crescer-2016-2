

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CestoDeLembasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CestoDeLembasTest
{
    @Test
    public void cestoDeLembasNasceComQuantidade() {
        // Arrange
        int lembas = 11;
        // Act
        CestoDeLembas doisSemGluten = new CestoDeLembas(lembas);
        // Assert
        assertEquals(lembas, doisSemGluten.getQuantidadeDeLembas());
    }
    
    @Test
    public void podeDividirLembasEmPares() {
        // Arrange
        int lembasParesIndivisiveis = 2;
        // Act
        CestoDeLembas doisSemGluten = new CestoDeLembas(lembasParesIndivisiveis);
        // Assert
        assertFalse(doisSemGluten.podeDividirEmPares());
    }
    
    @Test
    public void podeDividir11LembasEmPares() {
        // Arrange
        int lembasImpares = 11;
        CestoDeLembas tresSemGluten = new CestoDeLembas(lembasImpares);
        // Act & Assert
        assertFalse(tresSemGluten.podeDividirEmPares());
    }
    
    @Test
    public void podeDividir42LembasEmPares() {
        // Arrange
        int lembasPares = 42;
        CestoDeLembas quatroSemGluten = new CestoDeLembas(lembasPares);
        // Act & Assert
        assertTrue(quatroSemGluten.podeDividirEmPares());
    }
    
    @Test
    public void podeDividir8000LembasEmPares() {
        // Arrange
        int lembas = 8000;
        CestoDeLembas cesto = new CestoDeLembas(lembas);
        // Act & Assert
        assertFalse(cesto.podeDividirEmPares());
    }
    
    @Test
    public void podeDividirMenos12LembasEmPares() {
        // Arrange
        int lembas = -12;
        CestoDeLembas cesto = new CestoDeLembas(lembas);
        // Act & Assert
        assertFalse(cesto.podeDividirEmPares());
    }
}
