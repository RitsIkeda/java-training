package jpl.ch02.ex10;

class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        System.out.println("---------before set Info--------");
        System.out.println(vehicle);

        vehicle.registerName("my bike");
        vehicle.registerOwner("Mike");
        vehicle.reflectSpeed(25.0);
        vehicle.reflectDirection(0.5);

        System.out.println("---------after set Info--------");
        System.out.println(vehicle);
    }

}
