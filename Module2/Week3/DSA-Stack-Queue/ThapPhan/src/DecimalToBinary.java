import java.util.Arrays;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 55;
        Stack<Integer> binaryStack = new Stack<>();
        while (decimal > 0) {
            binaryStack.push(decimal % 2);
            decimal = decimal / 2;
        }
        int[] binaryArray = new int[binaryStack.size()];
        int index = 0;
        while (!binaryStack.isEmpty()) {
            binaryArray[index++] = binaryStack.pop();
        }
        System.out.println(Arrays.toString(binaryArray));
    }
}
