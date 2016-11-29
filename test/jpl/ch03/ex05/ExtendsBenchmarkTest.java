package jpl.ch03.ex05;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExtendsBenchmarkTest {

    @Test
    public void test1 () {
        ExtendsBenchmark light = new ExtendsBenchmark(500);
        ExtendsBenchmark middle = new ExtendsBenchmark(); /* default 1000 */
        ExtendsBenchmark heavy = new ExtendsBenchmark(2000);

        long shortTime = light.repeat(1000);
        long middleTime = middle.repeat(1000);
        long longTime = heavy.repeat(1000);

        assertTrue( middleTime > shortTime );
        assertTrue( longTime > shortTime );
    }

    @Test
    public void test2 () {
        ExtendsBenchmark benchmark = new ExtendsBenchmark(100);

        long shortTime = benchmark.repeat(500);
        long middleTime = benchmark.repeat(1000);
        long longTime = benchmark.repeat(2000);

        assertTrue( middleTime > shortTime );
        assertTrue( longTime > shortTime );
    }
}
