import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 sides: ");
        double[] sides = new double[3];
        for (int i = 0; i < 3; i++) {
            try {
                sides[i] = sc.nextInt();
                TriangleChecker.checkPositiveSide(sides[i]);
            } catch (TriangleException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Kiem tra xong 3 canh");
        try {
            TriangleChecker.checkValidTriangle(sides[0], sides[1], sides[2]);
        } catch (TriangleException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Kiem tra xong tam giac");
    }
}
