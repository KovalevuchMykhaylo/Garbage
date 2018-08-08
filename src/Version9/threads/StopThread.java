package Version9.threads;

import java.io.Serializable;
import java.util.concurrent.*;

public class StopThread implements Serializable {

    private static volatile boolean stopRequested;

    static final long serialVersionUID = 1L;

//    threadWrongStop() will not stop ever
//    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    private static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {

//        threadWrongStop();
//        threadWillStop();
//        new Action().run();
//        Thread thread = new Thread(new Action());
//        thread.setName("Name");
//        thread.start();
//        new Thread(() -> new Action().run()).start();
        try {
            Future<Integer> future = calculate(10);
            System.out.println(future.get());
            future.cancel(true);
            executor.shutdown();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    private static Future<Integer> calculate(int input) {
        return executor.submit(() -> {
//            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
            return input * input;
        });
    }

    private static void threadWrongStop() throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested)
                i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

    private static void threadWillStop() throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested())
                i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }

    // Simple framework for timing concurrent execution
    private static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown(); // Tell timer we're ready
                try {
                    start.await(); // Wait till peers are ready
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown(); // Tell timer we're done
                }
            });
        }
        ready.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        start.countDown(); // And they're off!
        done.await(); // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }

    private static void run() {
        System.out.println("Task #2 is running");
    }
}
