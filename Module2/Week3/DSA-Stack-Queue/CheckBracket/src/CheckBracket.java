import java.util.Stack;

public class CheckBracket {
    public static boolean checkBracket(String input) {
        Stack<Character> stack = new Stack<>();
        char[] inputToCharArray = input.toCharArray();
        for (char item : inputToCharArray) {
            if (item == '(') {
                stack.push(item);
            } else if (item == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (left == item) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
