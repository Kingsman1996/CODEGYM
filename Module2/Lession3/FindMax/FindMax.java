import java.util.Arrays;
import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array's length: ");
        int size = sc.nextInt();
        if (size < 1 || size > 20) {
            System.out.println("Invalid Input");
        } else {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Enter the " + (i + 1) + " element");
                arr[i] = sc.nextInt();
            }
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            System.out.println("Input array: " + Arrays.toString(arr));
            System.out.println("Max is: " + max);
        }
    }
}
