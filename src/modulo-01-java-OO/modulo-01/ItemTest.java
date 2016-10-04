

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest
{
    @Test
    public void igualdadeDeItens() {
        assertTrue(new Item("Mamão", 71).equals(new Item("Mamão", 71)));
        assertFalse(new Item("Mamão", 71).equals(new Item("Maçã", 71)));
        assertFalse(new Item("Mamão", 71).equals(new Item("Mamão", 1)));
    }
}
