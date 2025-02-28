import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Your input list: ");
        System.out.println(Arrays.toString(list));
        BubbleByStep.bubbleSortByStep(list);
    }
}
