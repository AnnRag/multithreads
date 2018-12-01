package counters;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class play {

    @Benchmark
    @Group("Semaphore")
    public int SemaphoreCount(SemaphoreCounter semaphoreCounter) {
        return semaphoreCounter.plus();
    }

    @Benchmark
    @Group("Synchronized")
    public int SynchCount(SynchCounter Synch) {
        return Synch.add();
    }

    @Benchmark
    @Group("Atomic")
    public int AtomicCount(AtomicCounter atomicCounter) {
        return atomicCounter.increment();
    }

    @Benchmark
    @Group("Volatile")
    public int VolatileCount(VolatileCounter volatileCounter) {
        return volatileCounter.incr();
    }

    public static void main(String[] args) throws RunnerException {
        int numbers_thread = 4;
        Options opt = new OptionsBuilder().include(play.class.getSimpleName()).warmupIterations(10)
                .measurementIterations(20)
                .resultFormat(ResultFormatType.CSV)
                .result("Benchmark_Results_" + numbers_thread)
                .threadGroups(numbers_thread).forks(1).build();

        new Runner(opt).run();
    }
}
