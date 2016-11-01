package jpl.ch02.ex01;

public class Vehicle {

    /* TODO private */
    public double speed; /* km/h */
    public double direction; /* degree clockwise */
    public String owner;
    public String name;

    Vehicle() {
        speed = 0.0;
        direction = 0.0;
        owner = null;
        name = null;
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
    }
}
