package jpl.ch03.ex01;

import static org.junit.Assert.*;
import org.junit.Test;

public class PassengerVehicleTest {

    /* super class functions are tested by ex02 */
    @Test
    public void test1 () {
        PassengerVehicle passengerVehicle = new PassengerVehicle(2,1);
        assertEquals(2,passengerVehicle.getSeatNum());
        assertEquals(1,passengerVehicle.getSittingNum());
    }

    @Test
    public void test2 () {
        PassengerVehicle passengerVehicle = new PassengerVehicle();
        passengerVehicle.setSeatNum(10);
        assertEquals(10,passengerVehicle.getSeatNum());
        passengerVehicle.setSittingNum(11);
        assertEquals(0,passengerVehicle.getSittingNum());
        passengerVehicle.setSittingNum(-1);
        assertEquals(0,passengerVehicle.getSittingNum());
        passengerVehicle.setSittingNum(10);
        assertEquals(10,passengerVehicle.getSittingNum());
    }




}
