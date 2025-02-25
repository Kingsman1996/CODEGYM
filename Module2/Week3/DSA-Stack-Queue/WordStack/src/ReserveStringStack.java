import java.util.Arrays;
import java.util.Stack;

public class ReserveStringStack {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        String word = "HelloWorld";
        String[] wordToArray = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            stringStack.push(String.valueOf(word.charAt(i)));
            wordToArray[i] = String.valueOf(word.charAt(i));
        }
        System.out.println("Before: " + Arrays.toString(wordToArray));
        for (int i = 0; i < wordToArray.length; i++) {
            wordToArray[i] = stringStack.pop();
        }
        System.out.println("After: " + Arrays.toString(wordToArray));
    }
}
