package jpl.ch02.ex09;

public class Vehicle {

    /* TODO private */
    public double speed; /* km/h */
    public double direction; /* degree clockwise */
    public String owner;
    public String name;
    public static long nextID = 0;
    public final long vehicleID;

    public Vehicle() {
        speed = 0.0;
        direction = 0.0;
        owner = null;
        vehicleID = nextID++;
    }
    public Vehicle(String owner) {
        this();
        registerOwner(owner);
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
    public static long getMaxID() {
        if( nextID == 0) {
            return 0;
        } else {
            return nextID - 1;
        }
    }
    public void printVehicleInfo() {
        System.out.println("Vehicle name: " + name );
        System.out.println("owner name: " + owner );
        System.out.println("speed(km/h) " + speed + " km/h" );
        System.out.println("direction: " + direction + " degree (clockwise)" );
        System.out.println("vehicleID: " + vehicleID );
    }
    /* BAD HACK FOR TEST */
    public static void resetStaticField() {
        nextID = 0;
    }
}
