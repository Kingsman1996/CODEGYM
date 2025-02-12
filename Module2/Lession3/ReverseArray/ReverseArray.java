import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter the valid size of the array: ");
            size = sc.nextInt();
            if (size > 20 || size < 1) {
                System.out.println("Invalid size");
            }
        } while (size > 20 || size < 1);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the " + (i + 1) + " number: ");
            arr[i] = sc.nextInt();
        }
        System.out.println("The array is: " + Arrays.toString(arr));
        for (int j = 0; j < arr.length / 2; j++) {
            int temp = arr[j];
            arr[j] = arr[size - 1 - j];
            arr[size - 1 - j] = temp;
        }
        System.out.println("The reserved array is: " + Arrays.toString(arr));
    }
}
