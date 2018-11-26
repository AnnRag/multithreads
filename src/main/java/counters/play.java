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
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.SECONDS)
public class play {

    @Benchmark
    public int SemaphoreCount() {
        SemaphoreCounter semaphoreCounter = new SemaphoreCounter();
        return semaphoreCounter.plus();
    }

    @Benchmark
    public int SynchCount() {
        SynchCounter synchCounter = new SynchCounter();
        return synchCounter.add();
    }

    @Benchmark
    public int AtomicCount() {
        AtomicCounter atomicCounter = new AtomicCounter();
        return atomicCounter.increment();
    }

    @Benchmark
    public int VolatileCount() {
        VolatileCounter volatileCounter = new VolatileCounter();
        return volatileCounter.incr();
    }

    public static void main(String[] args) throws RunnerException {
        int numbers_thread = 8;
        Options opt = new OptionsBuilder().include(play.class.getSimpleName()).warmupIterations(10)
                .measurementIterations(20)
                .resultFormat(ResultFormatType.CSV)
                .result("Benchmark_Results_" + numbers_thread)
                .threads(numbers_thread).forks(1).build();

        new Runner(opt).run();
    }
