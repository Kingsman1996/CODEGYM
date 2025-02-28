import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
        SelectionSort.selectionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
