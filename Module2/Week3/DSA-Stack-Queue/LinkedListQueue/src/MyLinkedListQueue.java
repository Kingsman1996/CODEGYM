public class MyLinkedListQueue {
    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(int key) {
        Node newNode = new Node(key);
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public Node dequeue() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return temp;
    }
}
