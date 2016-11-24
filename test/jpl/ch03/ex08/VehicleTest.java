package jpl.ch03.ex08;

import static org.junit.Assert.*;
import org.junit.Test;


public class VehicleTest {

    private final static double DELTA = 0.0001;
    @Test
    public void test1 () {
        Vehicle bike = new Vehicle();
        bike.registerName("my bike");
        bike.registerOwner("mike");
        bike.reflectSpeed(15.0);
        bike.reflectDirection(0.1);

        Vehicle copyBike = bike.clone();
        assertTrue(bike.toString().equals(copyBike.clone().toString()));
    }

    @Test
    public void test2() {
        Vehicle bike = new Vehicle();
        Vehicle copyBike = bike.clone();
        bike.start();

        assertEquals(100.0,bike.getBattery(),DELTA);
        assertEquals(0.0,copyBike.getBattery(),DELTA);

    }
}
