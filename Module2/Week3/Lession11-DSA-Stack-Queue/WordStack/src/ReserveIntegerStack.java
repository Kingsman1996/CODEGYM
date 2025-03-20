import java.util.Arrays;
import java.util.Stack;

public class ReserveIntegerStack {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < numbers.length; i++) {
            integerStack.push(numbers[i]);
        }
        System.out.println("Before: " + integerStack);
        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = integerStack.pop();
        }
        System.out.println("After: " + Arrays.toString(numbers));
    }
}
