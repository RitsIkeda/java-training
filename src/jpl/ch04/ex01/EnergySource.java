package jpl.ch04.ex01;

interface EnergySource {
    abstract boolean empty();
    abstract void fillUp();
    abstract double getSource();
}

class Battery implements EnergySource  {
    private double battery;
    public boolean empty() {
        if(battery <= 0.0) {
            return true;
        } else {
            return false;
        }
    }
     public void fillUp() {
         battery = 100.0;
     }
      public double getSource() {
          return battery;
      }

}

class GasTank implements EnergySource  {
    protected int gas;
    protected final int capacity;

    GasTank(int capacity) {
        this.capacity = capacity;
    }

    public boolean empty() {
        if(gas == 0) {
            return true;
        } else {
            return false;
        }
    }
     public void fillUp() {
         gas = capacity;
     }
     public double getSource() {
         return (double) gas;
     }
}
