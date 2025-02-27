import java.util.Arrays;

public class InsertSortByStep {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int nextValue = arr[i];
            int position = i;
            System.out.println("Checking " + nextValue);
            while (position > 0 && nextValue < arr[position - 1]) {
                System.out.println(nextValue + " is less than " + arr[position - 1] + ", shifting...");
                arr[position] = arr[position - 1];
                position--;
            }
            if (position == 0) {
                System.out.println("Reached position 0 ");
            } else {
                System.out.println(nextValue + " is greater than " + arr[position - 1]);
            }
            arr[position] = nextValue;
            System.out.println("Inserted " + nextValue + " at position " + position);
            System.out.println("Array after iteration " + i + ": " + Arrays.toString(arr));
            System.out.println();
        }
    }
}
