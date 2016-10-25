package jpl.ch02.ex08;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void test1 () {
        LinkedList list1 = new LinkedList("list1");
        assertEquals("list1",list1.getData());
        assertNull(list1.callNext());
    }
    @Test
    public void test2 () {
        LinkedList list1 = new LinkedList("list1");
        LinkedList list2 = new LinkedList("list2");
        assertTrue(list1.registerNextList(list2));
        assertEquals(list2,list1.callNext());
    }

    @Test
    public void test3 () {
        LinkedList list1 = new LinkedList("list1");
        LinkedList list2 = new LinkedList("list2");
        LinkedList list3 = new LinkedList("list3");
        list1.registerNextList(list2);

        assertFalse(list1.registerNextList(list3));
        assertEquals(list2,list1.callNext());
        list1.forceNextList(list3);
        assertEquals(list3,list1.callNext());
    }
    @Test
    public void test4 () {
        LinkedList list1 = new LinkedList();
        assertNull(list1.getData());
    }

    @Test
    public void test5 () {
        LinkedList list2 = new LinkedList("list2");
        LinkedList list1 = new LinkedList("list1",list2);
        assertEquals("list1",list1.getData());
        assertEquals(list2,list1.callNext());
    }
}
