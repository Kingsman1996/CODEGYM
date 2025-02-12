import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class ColCount {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the col in array");
        int col = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][col];
        }
        System.out.println("The sum of the columns is: " + sum);
    }
}
