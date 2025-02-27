import java.util.Arrays;

public class BubbleByStep {
    public static void bubbleSortByStep(int[] list) {
        boolean needNextStep = true;
        for (int k = 1; k <= list.length && needNextStep; k++) {
            needNextStep = false;
            for (int i = list.length - 1; i >= k; i--) {
                if (list[i] < list[i - 1]) {
                    System.out.print("Swap " + list[i] + " with " + list[i - 1] + ": ");
                    int temp = list[i];
                    list[i] = list[i - 1];
                    list[i - 1] = temp;
                    needNextStep = true;
                    System.out.println(Arrays.toString(list));
                }
            }
            if (needNextStep == false) {
                System.out.println("Done !");
                break;
            }
            System.out.print("List after the " + k + " sort: ");
            System.out.println(Arrays.toString(list));
        }
    }
}
