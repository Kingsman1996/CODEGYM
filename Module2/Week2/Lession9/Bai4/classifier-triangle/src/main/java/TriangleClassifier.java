public class TriangleClassifier {
    public static String getTriangle(int sideA, int sideB, int sideC) {
        if (!isTriangle(sideA, sideB, sideC)) {
            return "Không phải tam giác";
        }
        if (sideA == sideB && sideA == sideC) {
            return "Tam giác đều";
        } else if (sideA == sideB && sideA != sideC
                || sideA == sideC && sideB != sideA
                || sideB == sideC && sideB != sideA) {
            return "Tam giác cân";
        } else {
            return "Tam giác thường";
        }
    }

    private static boolean isTriangle(int sideA, int sideB, int sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            return false;
        }
        if (sideA + sideB <= sideC || sideB + sideC <= sideA || sideA + sideC == sideB) {
            return false;
        }
        return true;
    }

}
