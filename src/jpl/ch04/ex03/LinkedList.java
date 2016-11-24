package jpl.ch04.ex03;


/* LinkedListはインタフェースにするべきでない。
 static final なフィルードを持つとリストとして破綻し、
 メソッドの宣言しか行うことができない */
interface InterfaceLinkedList {
    public LinkedList clone();
    public boolean registerNextList(LinkedList next);
    /* continue Declaration.... */

}

public class LinkedList implements Cloneable, InterfaceLinkedList {
    private LinkedList next;
    private Object data = 0;

    public LinkedList clone()  {
        LinkedList dst = new LinkedList();
        dst.next = this.next;
        return dst;
    }


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
    public void setData(Object data) {
        this.data = data;
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

    /* return count oneself and All in Next Data.
        no able to count before Data Number. */
    public int countAllNextList() {
        int count = 0;
        LinkedList src = this;
        do {
            count++;
            if(src.callNext() == null) { break;}
            src = src.callNext();
        } while(true);
        return count;
    }

}
