import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 sides length: ");
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        sc.nextLine();
        Triangle triangle = new Triangle(side1, side2, side3);
        System.out.println("Enter color: ");
        String color = sc.nextLine();
        triangle.setColor(color);
        System.out.println(triangle.toString());
        sc.close();
    }
}
