import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {
    @Test
    void testEquilateralTriangle() {
        int sideA = 2;
        int sideB = 2;
        int sideC = 2;
        String result = TriangleClassifier.getTriangle(sideA, sideB, sideC);
        String expected = "Tam giác đều";
        assertEquals(expected, result);
    }

    @Test
    void testIsoscelesTriangle() {
        int sideA = 2;
        int sideB = 2;
        int sideC = 3;
        String result = TriangleClassifier.getTriangle(sideA, sideB, sideC);
        String expected = "Tam giác cân";
        assertEquals(expected, result);
    }

    @Test
    void testNormalTriangle() {
        int sideA = 3;
        int sideB = 4;
        int sideC = 5;
        String result = TriangleClassifier.getTriangle(sideA, sideB, sideC);
        String expected = "Tam giác thường";
        assertEquals(expected, result);
    }

    @Test
    void testNotTriangle1() {
        int sideA = -2;
        int sideB = 2;
        int sideC = 1;
        String result = TriangleClassifier.getTriangle(sideA, sideB, sideC);
        String expected = "Không phải tam giác";
        assertEquals(expected, result);
    }

    @Test
    void testNotTriangle2() {
        int sideA = 0;
        int sideB = 2;
        int sideC = 1;
        String result = TriangleClassifier.getTriangle(sideA, sideB, sideC);
        String expected = "Không phải tam giác";
        assertEquals(expected, result);
    }

    @Test
    void testNotTriangle3() {
        int sideA = 8;
        int sideB = 2;
        int sideC = 3;
        String result = TriangleClassifier.getTriangle(sideA, sideB, sideC);
        String expected = "Không phải tam giác";
        assertEquals(expected, result);
    }
}