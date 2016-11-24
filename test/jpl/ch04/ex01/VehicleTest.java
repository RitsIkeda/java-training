package jpl.ch04.ex01;

import static org.junit.Assert.*;
import org.junit.Test;

public class VehicleTest {
    private final static double DELTA = 0.0001;

    @Test
    public void test1 () {
        Vehicle vehicle = new Vehicle();
        assertEquals(0.0, vehicle.getBattery(), DELTA);
        vehicle.start();
        assertEquals(100.0, vehicle.getBattery(), DELTA);
    }
}
