package jpl.ch02.ex08;

class Main {
    public static void main(String[] args) {
        LinkedList emptyList = new LinkedList();
        LinkedList nextList = new LinkedList("nextList");
        LinkedList linkedList = new LinkedList("linkedList", nextList);

        System.out.println("nextList:" + nextList.getData());
        System.out.println("nextList's next:" + nextList.callNext());
        System.out.println("linkedList:" + linkedList.getData());
        System.out.println("linkedList's next:" + linkedList.callNext().getData());
        System.out.println("emptyList:" + emptyList.getData());
        System.out.println("emptyList's next:" + emptyList.callNext());
    }
}
