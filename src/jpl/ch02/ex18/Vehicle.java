package jpl.ch02.ex18;

enum FixedDirection {
    LEFT(-10.0),
    RIGHT(10.0);

    double value;
    FixedDirection(double value) {this.value = value;}

}
public class Vehicle {
    private double speed; /* km/h */
    private double direction; /* degree clockwise */
    private String owner;
    private String name;
    private static long nextID = 0;
    private final long vehicleID;

    public final FixedDirection TRUN_LEFT = FixedDirection.LEFT;
    public final FixedDirection TRUN_RIGHT = FixedDirection.RIGHT;

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
    /* return true:Accelerated false:Decelerated */
    public boolean changeSpeed(double speed) {
        double before = this.speed;
        reflectSpeed(speed);
        if(speed >= before) {
            return true;
        } else {
            return false;
        }
    }
    public void stop() {
        reflectSpeed(0.0);
    }
    public void reflectDirection(double direction) {
        this.direction = direction;
    }
    public void trun(double direction) {
         reflectDirection(direction);
    }

    public void turn(FixedDirection fixedDirection) {
        reflectDirection(fixedDirection.value);
    }

    public String getName() {
        return name;
    }
    public String getOwner() {
        return owner;
    }
    public double getSpeed() {
        return speed;
    }
    public double getDirection() {
        return direction;
    }
    public long getID() {
        return vehicleID;
    }

    public static long getMaxID() {
        if( nextID == 0) {
            return 0;
        } else {
            return nextID - 1;
        }
    }

    public String toString() {
        String str = "name:" + name;
         str += " / owner:" + owner;
         str += " / speed:" + speed;
         str += " / direction:" + direction;
         return str;
    }

    public void printVehicleInfo() {
        System.out.println("Vehicle name: " + name );
        System.out.println("owner name: " + owner );
        System.out.println("speed(km/h) " + speed + " km/h" );
        System.out.println("direction: " + direction + " degree (clockwise)" );
        System.out.println("vehicleID: " + vehicleID );
    }
    public static void main(String[] args) {
        Vehicle vehicles[] = new Vehicle[args.length];
        for(int  i = 0; i < args.length; i++ ) {
            vehicles[i] = new Vehicle(args[i]);
            System.out.println("owner name: " + vehicles[i].getOwner());
        }
    }
}
