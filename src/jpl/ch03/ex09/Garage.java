package jpl.ch03.ex09;

import jpl.ch03.ex08.Vehicle;

public class Garage implements Cloneable {

    private static final int CAPACITY = 10;
    private Vehicle[] vehicles = new Vehicle[CAPACITY];

    public Garage clone()  {
        try {
            Garage dst = (Garage) super.clone();
            return dst;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    public void copy(Garage other) {
        for (int i = 0; i < CAPACITY; i++ ){
            this.vehicles[i] = other.vehicles[i].clone();
        }
    }

    public static void main(String args[]) {
        Garage garage = new Garage();
        garage.vehicles[0] = new Vehicle("mike");
        garage.vehicles[1] = new Vehicle("lenna");
        garage.vehicles[2] = new Vehicle("john");
        garage.vehicles[9] = new Vehicle("ann");
        Garage copyGarage = garage.clone();

        for(int i = 0; i < CAPACITY; i++) {
            if(garage.vehicles[i] != null && garage.vehicles[i] != null) {
            System.out.println( i + " src:" + garage.vehicles[i].getOwner() +
            " dst:" + copyGarage.vehicles[i].getOwner());
            } else {
                System.out.println( i + " src:" + garage.vehicles[i] +
                " dst:" + copyGarage.vehicles[i]);
            }
        }
    }

}
