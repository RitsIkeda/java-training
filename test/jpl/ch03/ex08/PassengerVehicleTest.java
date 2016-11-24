package jpl.ch03.ex08;

import static org.junit.Assert.*;
import org.junit.Test;


public class PassengerVehicleTest {

    private final static double DELTA = 0.0001;
    @Test
    public void test1 () {
        PassengerVehicle car = new PassengerVehicle();
        car.registerName("my bike");
        car.registerOwner("mike");
        car.reflectSpeed(15.0);
        car.reflectDirection(0.1);
        car.setSeatNum(5);
        car.setSittingNum(4);

        PassengerVehicle copyCar = car.clone();
        assertTrue(car.toString().equals(copyCar.clone().toString()));
    }

    @Test
    public void test2() {
        PassengerVehicle car = new PassengerVehicle();
        PassengerVehicle copyCar = car.clone();
        car.start();

        assertEquals(100.0,car.getBattery(),DELTA);
        assertEquals(0.0,copyCar.getBattery(),DELTA);

    }
}
