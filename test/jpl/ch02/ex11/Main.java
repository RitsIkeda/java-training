package jpl.ch02.ex11;

import jpl.ch02.ex10.Vehicle;

class Main {
    public static void main(String[] args) {
        Vehicle myBike = new Vehicle();
        Vehicle speedCar = new Vehicle();
        Vehicle noname = new Vehicle();

        myBike.registerName("my bike");
        myBike.registerOwner("mike");

        speedCar.registerName("speed car");
        speedCar.registerOwner("lenna");
        speedCar.reflectSpeed(100.0);
        speedCar.reflectDirection(0.1);

        LinkedList list2 = new LinkedList(noname);
        LinkedList list1 = new LinkedList(speedCar, list2);
        LinkedList list0 = new LinkedList(myBike, list1);

        System.out.println(list0);
    }
}
