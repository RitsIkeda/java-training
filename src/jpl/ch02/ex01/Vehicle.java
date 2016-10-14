package jpl.ch02.ex01;

class Vehicle {
    private double speed; /* km/h */
    private double direction; /* degree clockwise */
    private String owner;
    private String name;

    Vehicle() {
        speed = 0.0;
        direction = 0.0;
        owner = null;
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
