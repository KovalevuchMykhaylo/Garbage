package Version9.threads;

public class Action implements Runnable {

    @Override
    public void run() {
        System.out.println("I am running: " + Thread.currentThread().getName());
    }
}
