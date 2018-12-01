package counters;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.Semaphore;

@State(Scope.Benchmark)
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
