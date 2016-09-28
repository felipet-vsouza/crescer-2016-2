

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
        int lembasImpares = 11;
        int lembasPares = 42;
        int lembasParesIndivisiveis = 2;
        // Act
        CestoDeLembas tresSemGluten = new CestoDeLembas(lembasImpares);
        CestoDeLembas quatroSemGluten = new CestoDeLembas(lembasPares);
        CestoDeLembas doisSemGluten = new CestoDeLembas(lembasParesIndivisiveis);
        // Assert
        assertEquals(false, tresSemGluten.podeDividirEmPares());
        assertEquals(true, quatroSemGluten.podeDividirEmPares());
        assertEquals(false, doisSemGluten.podeDividirEmPares());
    }
}
