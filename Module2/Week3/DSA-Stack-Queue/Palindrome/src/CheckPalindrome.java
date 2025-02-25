import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckPalindrome {
    public static boolean checkPalindrome(String input) {
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();
        char[] inputToArray = cleanInput.toCharArray();
        Stack<Character> inputStack = new Stack<>();
        Queue<Character> inputQueue = new LinkedList<>();
        for (int i = 0; i < inputToArray.length; i++) {
            inputStack.push(inputToArray[i]);
            inputQueue.add(inputToArray[i]);
        }
        boolean isPalindrome = true;
        while (!inputStack.isEmpty()) {
            if (!inputStack.pop().equals(inputQueue.remove())) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
