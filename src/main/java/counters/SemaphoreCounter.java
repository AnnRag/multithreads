package counters;
import java.util.concurrent.Semaphore;

public class SemaphoreCounter {

    Semaphore semaphore = new Semaphore(1);

    private int count;

    public int plus() {
        try {
            semaphore.acquire();
            count++;
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
        semaphore.release();
        return count;
    }
}
