package jpl.ch02.ex03;

class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.printVehicleInfo();
        for(int i = 0; i  < 100; i ++ ) {
            vehicle = new Vehicle();
        }
        System.out.println("101 times called");
        vehicle.printVehicleInfo();
    }
}
