import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (b * b) - (4 * a * c);
    }

    public double getRoot1() {
        return (-b + Math.pow(b * b - a * 4 * c, 0.5)) / (2 * a);
    }

    public double getRoot2() {
        return (-b - Math.pow(b * b - a * 4 * c, 0.5)) / (2 * a);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three points of equation:");
        double a = sc.nextDouble();
        while (a == 0) {
            System.out.println("Enter a != 0");
            a = sc.nextDouble();
        }
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double discriminant = equation.getDiscriminant();
        System.out.print("Equation is: " + equation.getA() + "x^2 + ");
        System.out.println(+equation.getB() + "x + " + equation.getC() + " = 0");
        if (discriminant > 0) {
            System.out.println("First root: " + equation.getRoot1());
            System.out.println("Second root: " + equation.getRoot2());
        } else if (discriminant == 0) {
            System.out.println("Only one root: " + equation.getRoot1());
        } else {
            System.out.println("No root");
        }
        sc.close();
    }
}
