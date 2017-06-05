package jpl.ch03.ex03;

class X {
    /* protected modifier is for debug.TODO private. */
    protected static final int xMask = 0x00ff;
    private int fullMask;

    public X() {
        printMask("X constructor start");
        fullMask = xMask;
        printMask("X constructor end");
    }
    public int mask (int orig) {
        return (orig & fullMask);
    }

    protected void printMask(String head) {
        System.out.printf( head + "\txMask:%04x fullMask:%04x" +
            System.getProperty("line.separator"), xMask,fullMask);
    }
}

public class Y extends X {
    private static final int yMask = 0xff00;
    private int fullMask; /* not overRide */

    public Y() {
        printMask("Y constructor start");
        fullMask |= yMask;
        printMask("Y constructor end");
    }
    protected void printMask(String head) {
        System.out.printf( head + "\txMask:%04x yMask:%04x fullMask:%04x" +
            System.getProperty("line.separator"), xMask,yMask,fullMask);
    }
    public static void main(String[] args) {
        System.out.println("X class create");
        @SuppressWarnings("unused")
		X x = new X();
        System.out.println("Y class create");
        @SuppressWarnings("unused")
		Y y = new Y();
    }

}
