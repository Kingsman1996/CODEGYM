public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println("dequeue: " + queue.dequeue().key);
        queue.enqueue(4);
        System.out.println("dequeue: " + queue.dequeue().key);
        queue.enqueue(5);
        System.out.println("dequeue: " + queue.dequeue().key);
    }
}
