package jpl.ch03.ex05;

public class ExtendsBenchmark extends Benchmark {

    final int DEFAULT_LOAD = 1000;
    protected volatile int load = DEFAULT_LOAD;
    protected volatile int index;

    protected void benchmark() {
        for( index = 0; index < load; index++ ) ;
    }
    ExtendsBenchmark() {}
    ExtendsBenchmark(int load) {
        this.load = load;
    }

    public final int getLoad() {
        return load;
    }
}

abstract class Benchmark {
    abstract void benchmark();

    public final long repeat(int count) {
        long start = System.nanoTime();
        for(int i = 0; i < count; i++) {
            benchmark();
        }
        return ( System.nanoTime() - start );
    }
}
