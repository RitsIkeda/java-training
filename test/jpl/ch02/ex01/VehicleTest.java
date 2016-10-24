package jpl.ch02.ex01;

import static org.junit.Assert.*;
import org.junit.Test;

public class VehicleTest {

    private static final double DELTA = 0.0001;
    @Test
    public void test1 () {
        Vehicle vehicle = new Vehicle();
        assertNull(vehicle.name);
        vehicle.registerName("my bike");
        assertEquals("my bike", vehicle.name);
    }
    @Test
    public void test2 () {
        Vehicle vehicle = new Vehicle();
        assertNull(vehicle.owner);
        vehicle.registerOwner("mike");
        assertEquals("mike", vehicle.owner);
    }
    @Test
    public void test3 () {
        Vehicle vehicle = new Vehicle();
        assertEquals(0.0, vehicle.speed,DELTA);
        vehicle.reflectSpeed(40.0);
        assertEquals(40.0, vehicle.speed,DELTA);
    }
    @Test
    public void test4 () {
        Vehicle vehicle = new Vehicle();
        assertEquals(0.0, vehicle.direction,DELTA);
        vehicle.reflectDirection(10.0);
        assertEquals(10.0, vehicle.direction,DELTA);
    }
}
