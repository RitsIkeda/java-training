package jpl.ch01.ex08;

import static org.junit.Assert.*;
import org.junit.Test;

public class PointTest {
    private static final double DELTA = 0.0001;

    @Test
    public void test1 () {
        Point p = new Point();
        assertEquals(0.0,p.x,DELTA);
        assertEquals(0.0,p.y,DELTA);
    }
    @Test
    public void test2 () {
        Point p = new Point();
        p.setPoint(	Math.PI, -Math.E);
        assertEquals(Math.PI,p.x,DELTA);
        assertEquals(-Math.E,p.y,DELTA);
    }
    @Test
    public void test3 () {
        Point p = new Point();
        double d = 0.0;
        do {
            d += 1.1;
            p.setPoint(	Math.PI * d, -Math.E * d);
        } while (d < 10.0);
        assertEquals(Math.PI * d,p.x,DELTA);
        assertEquals(-Math.E * d,p.y,DELTA);
    }
}
