import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Draw the triangle");
        System.out.println("2. Draw the square");
        System.out.println("3. Draw the rectangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        int i = 1;
        switch (choice) {
            case 1:
                while (i < 6) {
                    int j = 0;
                    while (j < i) {
                        System.out.print("*");
                        j++;
                    }
                    System.out.println("");
                    i++;
                }
                break;
            case 2:
                while (i < 6) {
                    for (int k = 0; k < 13; k++) {
                        System.out.print("*");
                    }
                    System.out.println("");
                    i++;
                }
                break;
            case 3:
                while (i < 4) {
                    for (int j = 0; j < 13; j++) {
                        System.out.print("*");
                    }
                System.out.println("");
                i++;
                }
                break;
            default:
                System.out.println("No Choice");
        }
    }
}
