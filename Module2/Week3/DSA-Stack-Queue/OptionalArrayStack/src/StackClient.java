import java.util.Arrays;

public class StackClient {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(18);
        stack.push(37);
        stack.push(21);
        System.out.println("Size before popping: " + stack.getSize());
        System.out.println("Top element index: " + stack.getTop());
        System.out.println("Popping: " + stack.pop());
        System.out.println("Size after popping: " + stack.getSize());
    }
}
