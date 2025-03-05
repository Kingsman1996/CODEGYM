public class Main {
    public static void main(String[] args) {
        Thread oddThread = new Thread(new OddThread(), "OddThread");
        Thread evenThread = new Thread(new EvenThread(), "EvenThread");
        oddThread.start();
        try {
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println("OddThread is interrupted");
        }
        evenThread.start();
    }
}
