package jpl.ch02.ex13;

class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        System.out.println(vehicle.getName());
        vehicle.registerName("my bike");
        System.out.println(vehicle.getName());

        System.out.println(vehicle.getOwner());
        vehicle.registerOwner("Mike");
        System.out.println(vehicle.getOwner());

        System.out.println(vehicle.getSpeed());
        vehicle.reflectSpeed(25.0);
        System.out.println(vehicle.getSpeed());

        System.out.println(vehicle.getDirection());
        vehicle.reflectDirection(0.5);
        System.out.println(vehicle.getDirection());
    }

}
