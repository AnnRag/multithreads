package counters;

public class VolatileCounter {

    private volatile int count;

    public int incr(){
        synchronized(this) {
            return count++;
        }
    }
}
