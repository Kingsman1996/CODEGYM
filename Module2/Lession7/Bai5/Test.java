public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(3, "red", true);
        shapes[1] = new Rectangle(2, 5);
        shapes[2] = new Circle(4, "green", false);
        shapes[3] = new Square(4.5);
        for (int i = 0; i < 4; i++) {
            System.out.print("Before: " + shapes[i].toString());
            shapes[i].resize(100);
            if (shapes[i] instanceof Colorable) {
                ((Colorable) shapes[i]).howToColor();
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("After: " + shapes[i].toString());
        }
    }
}
