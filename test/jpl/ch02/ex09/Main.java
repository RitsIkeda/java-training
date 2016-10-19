package jpl.ch02.ex09;

class Main {
    public static void main(String[] args) {
        int count = 0;
        printMaxIDandCalledCount(Vehicle.getMaxID(), count);

        Vehicle vehicle = new Vehicle();
        count++;
        printMaxIDandCalledCount(Vehicle.getMaxID(), count);

        for( ; count  < 100; count++ ) {
            vehicle = new Vehicle();
        }
        printMaxIDandCalledCount(Vehicle.getMaxID(), count);
    }

    private static void printMaxIDandCalledCount(long id, int count) {
        System.out.println("MaxID: " + id + " CalledCount: " + count );
    }

}
