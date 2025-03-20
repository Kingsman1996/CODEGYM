import java.util.Scanner;

public class FindMinPractice {
    public static boolean checkValidLength(int length) {
        if (length < 1 || length > 20) {
            System.out.println("Invalid length");
            return false;
        }
        return true;
    }

    public static void enterElement(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter " + (i + 1) + " element");
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int length = sc.nextInt();
        if (checkValidLength(length)) {
            int[] array = new int[length];
            enterElement(array);
            System.out.println("Min in array: " + findMin(array));
        }
    }
}
