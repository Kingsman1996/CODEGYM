
public class GenericStackClient {
    public static void stackOfString(){
        MyGenericStack<String> stringStack = new MyGenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");
        stringStack.push("Stack");
        System.out.println("Size of stack: " + stringStack.size());
        System.out.println("Pop element: " + stringStack.pop());
        System.out.println( "Size of stack: " + stringStack.size());
    }
    public static void stackOfInteger(){
        MyGenericStack<Integer> integerStack = new MyGenericStack<>();
        integerStack.push(1);
        integerStack.push(12);
        integerStack.push(33);
        integerStack.push(44);
        System.out.println("Size of stack: " + integerStack.size());
        System.out.println("Pop element: " + integerStack.pop());
        System.out.println( "Size of stack: " + integerStack.size());
    }

    public static void main(String[] args) {
        System.out.print("String stack: ");
        stackOfString();
        System.out.println();
        System.out.print("Integer stack: ");
        stackOfInteger();
    }
}
