public class MyStack {
    private int size;
    private int topElementIndex;
    private int[] arr;

    public MyStack() {
    }

    public MyStack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.topElementIndex = -1;
    }

    public boolean isEmpty() {
        return topElementIndex == -1;
    }

    public boolean isFull() {
        return topElementIndex == size - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            topElementIndex++;
            arr[topElementIndex] = value;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else {
            topElementIndex--;
            return arr[topElementIndex + 1];
        }
    }

    public int getTop() {
        return topElementIndex;
    }

    public int getSize() {
        return size;
    }

    public int getElements() {
        return topElementIndex + 1;
    }
}
