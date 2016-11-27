package jpl.ch06.ex02;

import static org.junit.Assert.*;
import org.junit.Test;

public class VehicleTest {
    private static final double DELTA = 0.0001;

    @Test
    public void test1 () {
        Vehicle vehicle = new Vehicle();
        vehicle.turn(Vehicle.TURN_LEFT);
        assertEquals(FixedDirection.LEFT.value, vehicle.getDirection(),DELTA);
        vehicle.turn(Vehicle.TURN_RIGHT);
        assertEquals(FixedDirection.RIGHT.value, vehicle.getDirection(),DELTA);
    }
}
