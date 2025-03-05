public class Main {
    public static void main(String[] args) {
        Thread generator1 = new Thread(new NumberGenerator(), "Thread 1");
        Thread generator2 = new Thread(new NumberGenerator(), "Thread 2");
        generator1.setPriority(Thread.MAX_PRIORITY);
        generator2.setPriority(Thread.MIN_PRIORITY);
        generator1.start();
        generator2.start();
    }
}
