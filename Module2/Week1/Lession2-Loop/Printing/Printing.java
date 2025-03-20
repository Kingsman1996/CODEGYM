import java.util.Scanner;

public class Printing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print the isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        int width;
        int height;
        switch (choice) {
            case 1:
                System.out.println("Enter width: ");
                width = sc.nextInt();
                System.out.println("Enter height: ");
                height = sc.nextInt();
                for (int i = 1; i <= height; i++) {
                    for (int j = 1; j <= width; j++) {
                        System.out.print("0");
                    }
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("Choose squared corner");
                System.out.println("1. Top_left");
                System.out.println("2. Top_right");
                System.out.println("3. Bottom_left");
                System.out.println("4. Bottom_right");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        for (int i = 0, j = 6; i < 6; i++, j--) {
                            int k = 0;
                            while (k < j) {
                                System.out.print("0");
                                k++;
                            }
                            System.out.println();
                        }
                        break;
                    case 2:
                        for (int i = 0, j = 6, k = 1; i < 6; i++, j--, k++) {
                            for (int l = 0; l < k; l++) {
                                System.out.print(" ");
                            }
                            for (int m = 0; m < j; m++) {
                                System.out.print("0");
                            }
                            System.out.println();
                        }
                        break;
                    case 3:
                        for (int i = 0, j = 0; i < 6; i++, j++) {
                            for (int l = 0; l <= j; l++) {
                                System.out.print("0");
                            }
                            System.out.println();
                        }
                        break;
                    case 4:
                        for (int i = 0, j = 5; i < 6; i++, j--) {
                            for (int l = 0; l < j; l++) {
                                System.out.print(" ");
                            }
                            for (int m = 0; m <= i; m++) {
                                System.out.print("0");
                            }
                            System.out.println();
                        }
                }
                break;
            case 3:
                for (int i = 0, j = 7, k = 1; i < 7; i++, j--, k += 2) {
                    int l = 0;
                    while (l < j) {
                        System.out.print(" ");
                        l++;
                    }
                    for (int m = 0; m < k; m++) {
                        System.out.print("0");
                    }
                    l = 0;
                    while (l < j) {
                        System.out.print(" ");
                        l++;
                    }
                    System.out.println();
                }
                break;
            case 4:
                System.out.println("No Choice");
        }
    }
}