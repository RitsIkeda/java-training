package jpl.ch09.ex01;

public class InfinityTrial {
    private static final double POS_INF = Double.POSITIVE_INFINITY;
    private static final double NEGA_INF = Double.NEGATIVE_INFINITY;

    public static void main(String args[]) {
        System.out.println("POS + POS  = " + (POS_INF + POS_INF) );
        System.out.println("POS + NEGA = " + (POS_INF + NEGA_INF) );
        System.out.println("POS - POS  = " + (POS_INF - POS_INF) );
        System.out.println("POS - NEGA = " + (POS_INF - NEGA_INF) );
        System.out.println("POS * POS  = " + POS_INF * POS_INF );
        System.out.println("POS * NEGA = " + POS_INF * NEGA_INF );
        System.out.println("POS / POS  = " + POS_INF / POS_INF );
        System.out.println("POS / NEGA = "  + POS_INF / NEGA_INF );
    }
}
