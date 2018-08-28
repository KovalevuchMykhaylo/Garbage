package Version9.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreStudy {

    private final static Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args) {
        int answer = 14;
        Thread t = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The answer is: " + answer);
        });
        t.start();
        System.out.println(semaphore.availablePermits());
        semaphore.release();
    }
}
