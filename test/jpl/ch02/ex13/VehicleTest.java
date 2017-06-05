package jpl.ch02.ex13;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

    private static final double DELTA = 0.0001;
    @Test
    public void test1 () {
        Vehicle vehicle = new Vehicle();
        assertNull(vehicle.getName());
        vehicle.registerName("my bike");
        assertEquals("my bike", vehicle.getName());
    }
    @Test
    public void test2 () {
        Vehicle vehicle = new Vehicle();
        assertNull(vehicle.getOwner());
        vehicle.registerOwner("mike");
        assertEquals("mike", vehicle.getOwner());
    }
    @Test
    public void test3 () {
        Vehicle vehicle = new Vehicle();
        assertEquals(0.0, vehicle.getSpeed(),DELTA);
        vehicle.reflectSpeed(40.0);
        assertEquals(40.0, vehicle.getSpeed(),DELTA);
    }
    @Test
    public void test4 () {
        Vehicle vehicle = new Vehicle();
        assertEquals(0.0, vehicle.getDirection(),DELTA);
        vehicle.reflectDirection(10.0);
        assertEquals(10.0, vehicle.getDirection(),DELTA);
    }
    @Test
    public void test5 () {
        Vehicle.resetStaticField();

        Vehicle vehicle = new Vehicle();
        assertEquals(0, vehicle.getID());
        assertEquals(1, Vehicle.getNextID());
    }
    @Test
    public void test6 () {
        Vehicle.resetStaticField();

        for(int i = 0; i < 100; i++) {
            @SuppressWarnings("unused")
			Vehicle dummy = new Vehicle();
        }
        Vehicle vehicle = new Vehicle();
        assertEquals(100, vehicle.getID());
        assertEquals(101, Vehicle.getNextID());
    }

    @Test
    public void test7() {
        Vehicle myBike = new Vehicle("mike");
        Vehicle speedCar = new Vehicle("lenna");
        Vehicle noname = new Vehicle(null);
        assertEquals("mike",myBike.getOwner());
        assertEquals("lenna",speedCar.getOwner());
        assertNull(noname.getOwner());
    }
    @Test
    public void test8 () {
        Vehicle.resetStaticField();

        assertEquals(0, Vehicle.getMaxID());
        for(int i = 0; i < 100; i++) {
            @SuppressWarnings("unused")
			Vehicle dummy = new Vehicle();
        }
        @SuppressWarnings("unused")
		Vehicle vehicle = new Vehicle();
        assertEquals(100,Vehicle.getMaxID());
    }
    @Test
    public void test9 () {
        Vehicle speedCar = new Vehicle();
        speedCar.registerName("speed car");
        speedCar.registerOwner("lenna");
        speedCar.reflectSpeed(123.4);
        speedCar.reflectDirection(0.1234);

        assertNotSame(speedCar.toString().indexOf("speed car"),-1);
        assertNotSame(speedCar.toString().indexOf("lenna"),-1);
        assertNotSame(speedCar.toString().indexOf("123.4"),-1);
        assertNotSame(speedCar.toString().indexOf("0.1234"),-1);
    }
}
