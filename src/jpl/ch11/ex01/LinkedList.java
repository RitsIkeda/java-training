package jpl.ch11.ex01;

public class LinkedList<E> {
    private LinkedList<E> next;
    private E data;

    LinkedList() {
        this.data = null;
        this.next = null;
    }
    LinkedList(E data) {
        this();
        this.data = data;
    }
    LinkedList(E data, LinkedList<E> next) {
        this();
        this.data = data;
        this.next = next;
    }


    public boolean registerNextList(LinkedList<E> next) {
        if(this.next == null) {
            this.next = next;
            return true;
        } else {
            return false;
        }
    }
    public void forceNextList(LinkedList<E> next) {
        this.next = next;
    }
    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }
    public LinkedList<E> callNext() {
        return this.next;
    }

    private static int listCount = 0;
    private static final String NEW_LINE = System.getProperty("line.separator");
    public String toString() {
        String desc = "[" + listCount + "]" + " " + data + " " + NEW_LINE;
        listCount++;
        if(callNext() != null) {
            desc += callNext().toString();
        }
        listCount = 0;
        return desc;
    }

    /* return count oneself and All in Next Data.
        no able to count before Data Number. */
    public int countAllNextList() {
        int count = 0;
        LinkedList<E> src = this;
        do {
            count++;
            if(src.callNext() == null) { break;}
            src = src.callNext();
        } while(true);
        return count;
    }

}
