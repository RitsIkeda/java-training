package jpl.ch02.ex06;

import jpl.ch02.ex05.Vehicle;

public class LinkedList {
    private LinkedList next;
    private Object data;

    LinkedList(Object data) {
        this.data = data;
        this.next = null;
    }

    public boolean registerNextList(LinkedList next) {
        if(this.next == null) {
            this.next = next;
            return true;
        } else {
            return false;
        }
    }
    public void forceNextList(LinkedList next) {
        this.next = next;
    }
    public Object getData() {
        return this.data;
    }
    public LinkedList callNext() {
        return this.next;
    }

    public static void main(String[] args) {
        Vehicle myBike = new Vehicle();
        Vehicle speedCar = new Vehicle();
        Vehicle bigTrack = new Vehicle();

        myBike.registerName("my bike");
        myBike.registerOwner("mike");
        speedCar.registerName("speed car");
        speedCar.registerOwner("lenna");
        bigTrack.registerName("big track");
        bigTrack.registerOwner("john");
        LinkedList list1 = new LinkedList(myBike);
        LinkedList list2 = new LinkedList(speedCar);
        LinkedList list3 = new LinkedList(bigTrack);
        list1.registerNextList(list2);
        list2.registerNextList(list3);

        ((Vehicle) list1.getData()).printVehicleInfo();
        ((Vehicle) list1.callNext().getData()).printVehicleInfo();
        ((Vehicle) list1.callNext().callNext().getData()).printVehicleInfo();
    }
}
