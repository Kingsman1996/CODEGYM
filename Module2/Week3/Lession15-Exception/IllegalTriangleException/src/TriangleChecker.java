public class TriangleChecker {
    public static void checkValidTriangle(double side1, double side2, double side3) throws TriangleException {
        if (side1 + side2 <= side3 || side3 + side1 <= side2 || side2 + side3 <= side1) {
            throw new TriangleException("3 Sides do not form a valid triangle");
        }
    }

    public static void checkPositiveSide(double side) throws TriangleException {
        if (side <= 0) {
            throw new TriangleException("Side is not positive: " + side);
        }
    }
}
