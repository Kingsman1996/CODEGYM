public class QueueClient {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(3);
        queue.enqueue(17);
        queue.enqueue(25);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
