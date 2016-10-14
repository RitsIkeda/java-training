package jpl.ch02.ex01;

class Main {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        System.out.println("---------before set Info--------");
        vehicle.printVehicleInfo();

        System.out.println("---------after set Info--------");
        vehicle.registerName("my bike");
        vehicle.registerOwner("Mike");
        vehicle.reflectSpeed(25.0);
        vehicle.reflectDirection(0.5);
        vehicle.printVehicleInfo();
    }
}
