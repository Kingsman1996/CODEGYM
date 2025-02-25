import java.util.Arrays;

public class StackClient {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(18);
        stack.push(37);
        stack.push(21);
        System.out.println("Elements before popping: " + stack.getElements());
        System.out.println("Top element index: " + stack.getTop());
        System.out.println("Popping: " + stack.pop());
        System.out.println("Elements after popping: " + stack.getElements());
        stack.push(13);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        for (int i = 0; i <= stack.getSize(); i++) {
            stack.pop();
        }
    }
}
