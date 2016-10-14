package jpl.ch02.ex02;


class LinkedList {
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
}
