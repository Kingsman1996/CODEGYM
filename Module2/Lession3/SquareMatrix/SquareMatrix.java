import java.util.Scanner;
import java.util.Arrays;

public class SquareMatrix {
    public static void addElement(int[][] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Enter row " + (i + 1) + " column " + (j + 1) + " element");
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter each size of the square matrix");
        int row = sc.nextInt();
        if (row < 1) {
            System.out.println("Invalid size");
        } else {
            int[][] square = new int[row][row];
            addElement(square);
            int sum = 0;
            System.out.println("Array is: ");
            for (int i = 0; i < row; i++) {
                System.out.println(Arrays.toString(square[i]));
                sum += square[i][i];
            }
            System.out.println("The sum is: " + sum);
        }
    }
}
