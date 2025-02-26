import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextDayCalculatorTest {
    @Test
    void testNextDay() {
        assertArrayEquals(new int[]{21, 2, 2024}, NextDayCalculator.getNextDay(20, 2, 2024));
        assertArrayEquals(new int[]{1, 3, 2024}, NextDayCalculator.getNextDay(29, 2, 2024));
        assertArrayEquals(new int[]{1, 1, 2025}, NextDayCalculator.getNextDay(31, 12, 2024));
        assertArrayEquals(new int[]{1, 5, 2024}, NextDayCalculator.getNextDay(30, 4, 2024));
    }
}
