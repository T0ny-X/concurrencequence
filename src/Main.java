import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int trial = 100;
        int eachThread = 20;
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

        // Print out result
        System.out.println("Single thread took " + elapsedTime1 + " milliseconds");
        System.out.println("Multi-threads took " + elapsedTime2 + " milliseconds");
    }

    public static void generateInMultipleThreads(final int numThreads, final int trial) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(numThreads);
        // Iterate through to create threads and start it
        for (int i = 0; i < numThreads; i++) {
            new Thread(() -> {
                try {
                    Generator.generate(trial);
                } catch (Exception e) {
                    System.out.println("An error occurred in thread " + Thread.currentThread().getId());
                    e.printStackTrace(); //Basic error collection
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        latch.await();  // Wait for all threads to finish
        // Optional functions below
    }
}
