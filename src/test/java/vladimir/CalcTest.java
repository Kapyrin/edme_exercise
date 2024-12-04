package vladimir;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
   void testAddition() {
        assertEquals("18", Main.calc("9 + 9"));
        assertEquals("13", Main.calc("6 + 7"));
    }

    @Test
    void testSubtraction() {
        assertEquals("6", Main.calc("9 - 3"));
        assertEquals("0", Main.calc("5 - 5"));
    }

    @Test
    void testMultiplication() {
        assertEquals("27", Main.calc("9 * 3"));
        assertEquals("25", Main.calc("5 * 5"));
    }
    @Test
    void testDivision() {
        assertEquals("3", Main.calc("9 / 3"));
        assertEquals("1", Main.calc("5 / 5"));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> Main.calc("9 / 0"));
    }

    @Test
    void testInvalidNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> Main.calc("9 / a"));
    }

    @Test
    void testInvalidOperation() {
        assertThrows(IllegalArgumentException.class, () -> Main.calc("9 d 9"));
    }

}