package jpl.ch02.ex02;

class Main {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList("list1");
        LinkedList list2 = new LinkedList("list2");
        LinkedList list3 = new LinkedList("list3");

        System.out.println(list1.getData());

        if( list1.registerNextList(list2) ) {
            System.out.println(list1.callNext().getData());
        } else {
            System.out.println("error");
        }

        if( list1.registerNextList(list3) ) {
            System.out.println("error");
        } else {
            System.out.println(list1.callNext().getData());
        }

        list1.forceNextList(list3);
        System.out.println(list1.callNext().getData());
    }
}
