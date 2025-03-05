
public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization lazyT = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedT = new OptimizedPrimeFactorization();
        Thread lazyThread = new Thread(lazyT, "LazyThread");
        Thread optimizedThread = new Thread(optimizedT, "OptimizedThread");

        lazyThread.start();
        optimizedThread.start();
        try {
            lazyThread.join();
            optimizedThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lazy time: " + lazyT.getRunTime() + " ms");
        System.out.println("Optimized time: " + optimizedT.getRunTime() + " ms");
    }
}
