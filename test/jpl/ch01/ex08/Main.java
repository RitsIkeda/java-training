package jpl.ch01.ex08;

class Main {

    public static void main(String[] args) {
        Point p = new Point();
        System.out.println("x:" + p.x + " y:" + p.y);
        p.setPoint(5,-10.2);
        System.out.println("x:" + p.x + " y:" + p.y);
    }
}
