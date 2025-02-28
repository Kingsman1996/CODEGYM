import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {9, 30, 2, 15, 7};
        System.out.println("Before sorting " + Arrays.toString(array));
        System.out.println();
        InsertSortByStep.insertSort(array);
        System.out.println("After sorting " + Arrays.toString(array));
    }
}
