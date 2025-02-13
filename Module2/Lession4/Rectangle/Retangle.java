import java.util.Scanner;

public class Retangle {
    int width;
    int height;

    public Retangle() {
    }

    public Retangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return this.width * this.height;
    }

    public int getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public void display() {
        System.out.print("Width: " + this.width + " ");
        System.out.println("Height: " + this.height + " ");
        System.out.print("Area: " + this.getArea() + " ");
        System.out.println("Perimeter: " + this.getPerimeter());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputWidth = 0;
        int inputHeight = 0;
        do {
            System.out.println("Enter width > 0");
            inputWidth = sc.nextInt();
        } while (inputWidth < 1);
        do {
            System.out.println("Enter height > 0");
            inputHeight = sc.nextInt();
        } while (inputHeight < 1);
        Retangle inputRect = new Retangle(inputWidth, inputHeight);
        inputRect.display();
    }
}
