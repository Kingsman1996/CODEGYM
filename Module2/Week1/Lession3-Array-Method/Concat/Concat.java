import java.util.Arrays;
import java.util.Scanner;

public class Concat {
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
            System.out.println("Enter " + (i + 1) + " array element: ");
            arr[i] = sc.nextInt();
        }
    }

    public static void copyArray(int[] main, int[] copy1, int[] copy2) {
        for (int i = 0; i < copy1.length; i++) {
            main[i] = copy1[i];
        }
        for (int i = 0, j = copy1.length; i < copy2.length; i++, j++) {
            main[j] = copy2[i];
        }
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1Length;
        do {
            System.out.println("Enter first array length: ");
            arr1Length = sc.nextInt();
        } while (!checkValidLength(arr1Length));
        int[] arr1 = new int[arr1Length];
        enterElement(arr1);
        int arr2Length;
        do {
            System.out.println("Enter second array length: ");
            arr2Length = sc.nextInt();
        } while (!checkValidLength(arr2Length));
        int[] arr2 = new int[arr2Length];
        enterElement(arr2);
        int[] arr3 = new int[arr1Length + arr2Length];
        copyArray(arr3, arr1, arr2);
        printArray(arr3);
        sc.close();
    }
}
