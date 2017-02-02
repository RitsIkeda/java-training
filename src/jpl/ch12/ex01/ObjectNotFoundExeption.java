package jpl.ch12.ex01;

public class ObjectNotFoundExeption extends Exception {
    private Object notFoundObject;

    ObjectNotFoundExeption( Object notFoundObject) {
        this.notFoundObject = notFoundObject;
    }
    public String toString() {
        return super.toString() + notFoundObject.toString();
    }

}
