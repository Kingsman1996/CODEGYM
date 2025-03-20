public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }
    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return endTime - startTime;
    }
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        StopWatch sw = new StopWatch();
        sw.start();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        sw.stop();
        System.out.println("Thời gian đã trôi qua: " + sw.getElapsedTime() + " milisecond");
    }
}

