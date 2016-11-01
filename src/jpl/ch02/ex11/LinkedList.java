package jpl.ch02.ex11;

public class LinkedList {
    private LinkedList next;
    private Object data;

    LinkedList() {
        this.data = null;
        this.next = null;
    }
    LinkedList(Object data) {
        this();
        this.data = data;
    }
    LinkedList(Object data, LinkedList next) {
        this();
        this.data = data;
        this.next = next;
    }

    /* 下記コンストラクタはコピーコンストラクタとシグネチャが一致するため、
        定義するべきではない
    LinkedList(LinkedList next) */

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

}
