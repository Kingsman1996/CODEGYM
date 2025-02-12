import java.util.Arrays;
import java.util.Scanner;

public class DeteleElement {
    public static void main(String[] args) {
        int[] array = {10, 5, 2, 1, 3, 7, 9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position of element to detele: ");
        int element = sc.nextInt();
        boolean found = true;
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                found = true;
                position = i;
                break;
            } else {
                found = false;
            }
        }
        if (found) {
            for (int i = position; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0;
            System.out.println("New array: " + Arrays.toString(array));
        } else {
            System.out.println("Element not found");
        }
    }
}
