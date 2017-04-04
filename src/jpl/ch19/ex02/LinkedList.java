package jpl.ch19.ex02;

/**
 * Single linked list implementation Of Object
 * @version 1.0
 * @author Akinobu.Ikeda
 * @since 1.0
 */
public class LinkedList {

    /**
     * Linking next list node..
     */
    private LinkedList next;

    /**
     * Regsterd object in ths list.
     */
    private Object data;

    /**
     * Constructs an empty list
     */
    LinkedList() {
        this.data = null;
        this.next = null;
    }

    /**
     * Constructs a list containing the elements of the specified object
     * @param data specify registering object
     */
    LinkedList(Object data) {
        this();
        this.data = data;
    }
    /**
     * Constructs a list containing the elements of the specified object, and containing specified next list
     * @param data: specify registering object
     * @param next: specify adding list in front of current List
     */
    LinkedList(Object data, LinkedList next) {
        this();
        this.data = data;
        this.next = next;
    }

    /**
     * This method specify next List.
     * @param next: specfid next List
     * @return true: success / false: failue (maybe already registerd another list)
     */
    public boolean registerNextList(LinkedList next) {
        if(this.next == null) {
            this.next = next;
            return true;
        } else {
            return false;
        }
    }


    /**
     * This method specify next List.
     * @param next: specfid next List.
     * If another list registerd, it is rewritten..
     */
    public void forceNextList(LinkedList next) {
        this.next = next;
    }
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Returns the registering object at current List
     * @return registering object
     */
    public Object getData() {
        return this.data;
    }


    /**
     * This method returns registerd object.
     * @return registerd object.
     */
    public LinkedList getNext() {
        return this.next;
    }


    /**
     * Lists counter for representation of this collection.
     * @see #toString()
     */
    private static int listCount = 0;

    /**
     * New line code
     */
    private static final String NEW_LINE = System.getProperty("line.separator");


    /**
     * This method returns a string representation of this collection.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String desc = "[" + listCount + "]" + " " + data + " " + NEW_LINE;
        listCount++;
        if(getNext() != null) {
            desc += getNext().toString();
        }
        listCount = 0;
        return desc;
    }


    /**
     * This method returns the number of lists from this list.
     * @return  the number of lists from this list.
     */
    public int countAllNextList() {
        int count = 0;
        LinkedList src = this;
        do {
            count++;
            if(src.getNext() == null) { break;}
            src = src.getNext();
        } while(true);
        return count;
    }

}
