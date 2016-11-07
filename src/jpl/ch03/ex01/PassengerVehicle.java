package jpl.ch03.ex01;

import jpl.ch02.ex18.Vehicle;

public class PassengerVehicle extends Vehicle {
    public static void main(String[] args) {
        PassengerVehicle myBike = new PassengerVehicle();
        myBike.registerName("my Bike");
        myBike.registerOwner("mike");
        myBike.setSeatNum(2);
        myBike.setSittingNum(1);
        System.out.println(myBike);

        PassengerVehicle herCar = new PassengerVehicle();
        herCar.registerName("her Car");
        herCar.registerOwner("lenna");
        herCar.setSeatNum(5);
        herCar.setSittingNum(5);
        herCar.printVehicleInfo();
    }


    private int seatNum;
    private int sittingNum;

    PassengerVehicle() {
        super();
    }
    PassengerVehicle(int seatNum) {
        super();
        setSeatNum(seatNum);
    }
    PassengerVehicle(int seatNum,int sittingNum) {
        super();
        setSeatNum(seatNum);
        setSittingNum(sittingNum);
    }
    public int getSeatNum() {
        return seatNum;
    }
    public int getSittingNum() {
        return sittingNum;
    }
    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }
    public boolean setSittingNum(int sittingNum) {
        if(0 <= sittingNum && sittingNum <= seatNum) {
            this.sittingNum = sittingNum;
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        String str = super.toString();
        str += " / seatNum:" + seatNum;
        str += " / sittingNum:" + sittingNum;
        return str;
    }
    public void printVehicleInfo() {
        super.printVehicleInfo();
        System.out.println("seats number: " + seatNum );
        System.out.println("sitting peaple number: " + sittingNum );
    }
}
