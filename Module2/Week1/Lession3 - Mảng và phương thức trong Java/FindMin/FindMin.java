public class FindMin {
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("INVALID ARRAY");
            return -1;
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] array = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("Min in array: " + findMin(array));
    }
}
