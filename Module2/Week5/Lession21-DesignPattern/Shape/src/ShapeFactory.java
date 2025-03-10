public class ShapeFactory {
    public static Shape createShape(String shapeName) {
        if (shapeName.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        if (shapeName.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        if (shapeName.equalsIgnoreCase("square")) {
            return new Square();
        }
        throw new IllegalArgumentException("Unsupported shape: " + shapeName);
    }
}
