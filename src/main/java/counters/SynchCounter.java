package counters;

public class SynchCounter{

    private int count;

    public synchronized int add(){
        //synchronized(this) {
            //count++;
        //}
        return count ++;
    }
}