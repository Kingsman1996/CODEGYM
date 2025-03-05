public class OddThread implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("OddThread is interrupted");
        }
    }
}
