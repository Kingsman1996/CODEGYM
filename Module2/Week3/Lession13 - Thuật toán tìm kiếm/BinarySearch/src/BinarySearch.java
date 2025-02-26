public class BinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        int index = -1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key > list[mid])
                low = mid + 1;
            else {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] values = {10, 66, 88};
        for (int i = 0; i < values.length; i++) {
            int index = binarySearch(list, values[i]);
            if (index != -1) {
                System.out.println("Found " + values[i] + " at index " + index);
            } else {
                System.out.println(values[i] + " not found");
            }
        }
    }
}
