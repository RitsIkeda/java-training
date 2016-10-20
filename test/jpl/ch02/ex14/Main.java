package jpl.ch02.ex14;


class Main {
    public static void main(String[] args) {
        LinkedList list0 = new LinkedList();
        LinkedList list1 = new LinkedList("list1");
        LinkedList list2 = new LinkedList("list2");

        System.out.println(list0.getData());
        list0.setData("list0");
        System.out.println(list0.getData());

        System.out.println(list0.callNext());
        list0.registerNextList(list1);
        System.out.println(list0.callNext());

        list0.registerNextList(list2);
        System.out.println(list0.callNext());
        list0.forceNextList(list2);
        System.out.println(list0.callNext());

    }
}
