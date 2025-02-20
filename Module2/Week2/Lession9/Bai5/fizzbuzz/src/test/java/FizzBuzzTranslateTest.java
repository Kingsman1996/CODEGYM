import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTranslateTest {

    @Test
    void testFizz() {
        assertEquals("Fizz", FizzBuzzTranslate.getNumberType(3));
        assertEquals("Fizz", FizzBuzzTranslate.getNumberType(6));
        assertEquals("Fizz", FizzBuzzTranslate.getNumberType(13));
        assertEquals("Fizz", FizzBuzzTranslate.getNumberType(33));
    }

    @Test
    void testBuzz() {
        assertEquals("Buzz", FizzBuzzTranslate.getNumberType(5));
        assertEquals("Buzz", FizzBuzzTranslate.getNumberType(10));
        assertEquals("Buzz", FizzBuzzTranslate.getNumberType(52));
    }

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzzTranslate.getNumberType(15));
        assertEquals("FizzBuzz", FizzBuzzTranslate.getNumberType(30));
        assertEquals("FizzBuzz", FizzBuzzTranslate.getNumberType(35));
    }

    @Test
    void testInvalidNumbers() {
        assertEquals("Số không hợp lệ", FizzBuzzTranslate.getNumberType(-1));
        assertEquals("Số không hợp lệ", FizzBuzzTranslate.getNumberType(0));
        assertEquals("Số không hợp lệ", FizzBuzzTranslate.getNumberType(100));
    }

    @Test
    void testNumberSpell() {
        assertEquals("one", FizzBuzzTranslate.getNumberSpell(1));
        assertEquals("two", FizzBuzzTranslate.getNumberSpell(2));
        assertEquals("nine", FizzBuzzTranslate.getNumberSpell(9));
        assertEquals("two four", FizzBuzzTranslate.getNumberSpell(24));
        assertEquals("four seven", FizzBuzzTranslate.getNumberSpell(47));
    }
}
