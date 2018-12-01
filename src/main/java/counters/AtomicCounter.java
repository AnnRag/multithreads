package counters;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.atomic.AtomicInteger;

@State(Scope.Benchmark)
public class AtomicCounter {

    private AtomicInteger count = new AtomicInteger();

    public int increment() {
        return count.incrementAndGet();
    }
}
