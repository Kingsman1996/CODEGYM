public class LazyPrimeFactorization implements Runnable {
    private long runTime = 0;
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int n = 2; n <= 5000; n++) {
            boolean isPrime = true;
            for (int k = 2; k < n; k++) {
                if (n % k == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println("Prime " + n);
            }
        }
        long endTime = System.currentTimeMillis();
        runTime = endTime - startTime;
    }

    public long getRunTime() {
        return runTime;
    }
}
