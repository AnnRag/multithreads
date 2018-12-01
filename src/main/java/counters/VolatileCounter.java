package counters;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class VolatileCounter {

    private volatile int count;

    public int incr(){
        synchronized(this) {
            return count++;
        }
    }
}
