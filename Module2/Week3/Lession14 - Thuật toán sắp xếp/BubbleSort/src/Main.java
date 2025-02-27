import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {14, 5, 16, 7, 18, 9, 10, 31, 12, 23, 74, 55};
        BubbleSort.bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }
}
