package jpl.ch03.ex05;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExtendsBenchmarkTest {

    @Test
    public void test1 () {
        ExtendsBenchmark light = new ExtendsBenchmark(100);
        ExtendsBenchmark middle = new ExtendsBenchmark();
        ExtendsBenchmark heavy = new ExtendsBenchmark(10000);

        long shortTime = light.repeat(1000);
        long middleTime = middle.repeat(1000);
        long longTime = heavy.repeat(1000);

        assertEquals(1.0, (double) middleTime/ ((double) shortTime * 10.0), 0.3);
        assertEquals(1.0, (double) longTime/ ((double) middleTime * 10.0), 0.3);
    }

    @Test
    public void test2 () {
        ExtendsBenchmark benchmark = new ExtendsBenchmark(100);

        long shortTime = benchmark.repeat(100);
        long middleTime = benchmark.repeat(1000);
        long longTime = benchmark.repeat(10000);

        assertEquals(1.0, (double) middleTime/ ((double) shortTime * 10.0), 0.3);
        assertEquals(1.0, (double) longTime/ ((double) middleTime * 10.0), 0.3);
    }
}
