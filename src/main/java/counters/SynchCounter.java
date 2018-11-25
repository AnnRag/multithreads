package counters;

public class SynchCounter{

    private int count;

    public int add(){
        synchronized(this) {
            count++;
        }
        return count ++;
    }
}