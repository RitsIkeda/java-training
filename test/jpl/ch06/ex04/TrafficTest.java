package jpl.ch06.ex04;

import static org.junit.Assert.*;
import org.junit.Test;

public class TrafficTest {
    @Test
    public void test1 () {
        assertEquals(255, Traffic.RED.getColor().r);
        assertEquals(0, Traffic.RED.getColor().g);
        assertEquals(0, Traffic.RED.getColor().b);
    }
    @Test
    public void test2 () {
        assertEquals(255, Traffic.YELLOW.getColor().r);
        assertEquals(255, Traffic.YELLOW.getColor().g);
        assertEquals(0, Traffic.YELLOW.getColor().b);
    }
    @Test
    public void test3 () {
        assertEquals(0, Traffic.GREEN.getColor().r);
        assertEquals(255, Traffic.GREEN.getColor().g);
        assertEquals(0, Traffic.GREEN.getColor().b);
    }
}
