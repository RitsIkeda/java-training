package jpl.ch02.ex05;

public class Vehicle {
    private double speed; /* km/h */
    private double direction; /* degree clockwise */
    private String owner;
    private String name;
    private static long nextID = 0;
    private final long vehicleID;

    public static void main(String[] args){

        Vehicle myBike = new Vehicle();
        Vehicle speedCar = new Vehicle();
        Vehicle noname = new Vehicle();

        myBike.registerName("my bike");
        myBike.registerOwner("mike");

        speedCar.registerName("speed car");
        speedCar.registerOwner("lenna");
        speedCar.reflectSpeed(100.0);
        speedCar.reflectDirection(0.1);

        myBike.printVehicleInfo();
        speedCar.printVehicleInfo();
        noname.printVehicleInfo();
    }

    public Vehicle() {
        speed = 0.0;
        direction = 0.0;
        owner = null;
        vehicleID = nextID++;
    }

    public void registerName(String name) {
        this.name = name;
    }
    public void registerOwner(String owner) {
        this.owner = owner;
    }
    public void reflectSpeed(double speed) {
        this.speed = speed;
    }
    public void reflectDirection(double direction) {
        this.direction = direction;
    }

    public void printVehicleInfo() {
        System.out.println("Vehicle name: " + name );
        System.out.println("owner name: " + owner );
        System.out.println("speed(km/h) " + speed + " km/h" );
        System.out.println("direction: " + direction + " degree (clockwise)" );
        System.out.println("vehicleID: " + vehicleID );
    }
}
