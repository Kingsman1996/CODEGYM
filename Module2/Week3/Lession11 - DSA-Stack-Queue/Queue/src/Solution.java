import java.util.NoSuchElementException;

public class Solution {
    private Node front;
    private Node rear;

    public Solution() {
        front = rear = null;
    }

    public void enQueue(int element) {
        Node newNode = new Node(element);
        if (front == null) {
            front = rear = newNode;
            rear.link = front;
        } else {
            rear.link = newNode;
            rear = newNode;
            rear.link = front;
        }
    }

    public int deQueue() {
        if (front == null) {
            throw new NoSuchElementException("Hàng đợi rỗng!");
        }
        int element;
        if (front == rear) {
            element = front.data;
            front = rear = null;
        } else {
            element = front.data;
            front = front.link;
            rear.link = front;
        }
        return element;
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Hàng đợi rỗng!");
            return;
        }
        Node temp = front;
        System.out.print("Hàng đợi: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.link;
        } while (temp != front);
        System.out.println();
    }

    private class Node {
        public int data;
        public Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.enQueue(13);
        solution.enQueue(38);
        solution.enQueue(22);
        solution.displayQueue();
    }
}
