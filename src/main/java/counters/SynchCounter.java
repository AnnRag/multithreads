package counters;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class SynchCounter{

    private int count;

    public int add(){
        synchronized(this) {
            count++;
        }
        return count;
    }
}