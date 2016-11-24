package jpl.ch03.ex10;

import static org.junit.Assert.*;
import org.junit.Test;


public class LinkedListTest {

    @Test
    public void test1 () {
        LinkedList list = new LinkedList(10);
        LinkedList copyList =list.clone();

        assertNotEquals(list.getData(), copyList.getData());
        copyList.setData(10);
        assertEquals(list.getData(), copyList.getData());
    }

    @Test
    public void test2() {
        LinkedList list = new LinkedList();
        LinkedList refList  = new LinkedList(10);
        list.registerNextList(refList);
        LinkedList copyList =list.clone();

        assertEquals(list.callNext(), copyList.callNext());
        assertEquals(10, list.callNext().getData());
        assertEquals(10, copyList.callNext().getData());
        refList.setData(100);

        assertEquals(100, list.callNext().getData());
        assertEquals(100, copyList.callNext().getData());
    }
}
