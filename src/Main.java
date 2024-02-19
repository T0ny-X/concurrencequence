import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int trial = 1000;
        int eachThread = 200;
        // Start timing
        long startTime = System.nanoTime();

        Generator.generate(trial);

        // Stop timing
        long endTime = System.nanoTime();

        // Calculate time in milliseconds
        long elapsedTime1 = (endTime - startTime) / 1000000;


        // Repeat for the second method
        startTime = System.nanoTime();
        generateInMultipleThreads(trial/eachThread,eachThread);
        endTime = System.nanoTime();

        long elapsedTime2 = (endTime - startTime) / 1000000;
        System.out.println("Single thread took " + elapsedTime1 + " milliseconds");
        System.out.println("Multi-threads took " + elapsedTime2 + " milliseconds");
    }

    public static void generateInMultipleThreads(final int numThreads, final int trial) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            new Thread(() -> {
                try {
                    Generator.generate(trial);
                } catch (Exception e) {
                    System.out.println("An error occurred in thread " + Thread.currentThread().getId());
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        latch.await();  // Wait for all threads to finish
    }
}
