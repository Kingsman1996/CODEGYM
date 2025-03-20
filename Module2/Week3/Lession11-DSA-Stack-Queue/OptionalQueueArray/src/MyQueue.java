public class MyQueue {
    public int capacity;
    public int head;
    public int tail;
    public int currentSize;
    public int[] queueArray;

    public MyQueue() {
    }

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.head = 0;
        this.tail = -1;
        this.currentSize = 0;
    }

    public boolean isQueueEmpty() {
        return (currentSize == 0);
    }

    public boolean isQueueFull() {
        return (currentSize == capacity);
    }

    public void enqueue(int value) {
        if (isQueueFull()) {
            System.out.println("Queue is full");
        } else {
            tail = (tail + 1) % capacity;
            queueArray[tail] = value;
            currentSize++;
            System.out.println("Enqueued " + value);
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Dequeued " + queueArray[head]);
            head = (head + 1) % capacity;
            currentSize--;
        }
    }
}
