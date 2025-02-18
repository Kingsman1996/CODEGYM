public class Test {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[5];
        shapes[0] = new Circle(3, "red", true);
        shapes[1] = new Rectangle(2, 5);
        shapes[2] = new Circle(4, "green", false);
        for (int i = 0; i < 3; i++) {
            System.out.println("Before: " + shapes[i].toString());
        }
        shapes[0].resize(20);
        shapes[1].resize(50);
        shapes[2].resize(100);
        for (int i = 0; i < 3; i++) {
            System.out.println("After: " + shapes[i].toString());
        }
    }
}
