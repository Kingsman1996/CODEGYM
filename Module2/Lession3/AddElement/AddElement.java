import java.util.Scanner;
import java.util.Arrays;

public class AddElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = {10, 4, 6, 7, 8, 0, 0, 0, 0};
        System.out.println("Enter new element index");
        int index = sc.nextInt();
        if (index < 0 || index > array.length - 1) {
            System.out.println("Invalid index");
        } else {
            System.out.println("Enter element value");
            int value = sc.nextInt();
            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            System.out.println("New array: " + Arrays.toString(array));
        }
    }
}
