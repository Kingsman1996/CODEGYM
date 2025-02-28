import java.util.Scanner;

public class Debuggg {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', Enter a, b");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = sc.nextDouble();
        System.out.println("Enter b: ");
        double b = sc.nextDouble();
        if (a == 0) {
            if (b == 0) {
                System.out.println("Vo so nghiem");
            } else {
                System.out.println("Vo nghiem");
            }
        } else {
            double c = -b / a;
            System.out.println("Nghiem la " + c);
        }
    }
}
