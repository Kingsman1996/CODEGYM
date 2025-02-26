import java.util.Scanner;

public class FindMaxInMultiArray {
    public static boolean checkValidLength(int length) {
        if (length < 1 || length > 20) {
            System.out.println("Invalid length");
            return false;
        }
        return true;
    }

    public static void enterElement(int[][] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Enter element value at row " + i + " column " + j);
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    public static int findMaxInMultiArray(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowLength;
        do {
            System.out.println("Enter rows length: ");
            rowLength = sc.nextInt();
        } while (!checkValidLength(rowLength));
        int colLength;
        do {
            System.out.println("Enter cols length: ");
            colLength = sc.nextInt();
        } while (!checkValidLength(colLength));
        int[][] arr = new int[rowLength][colLength];
        enterElement(arr);
        System.out.println("Max value in array is: " + findMaxInMultiArray(arr));
        sc.close();
    }
}
