package jpl.ch04.ex03;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {

    /* from ex02 to ex03-10 */
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
    @Test
    public void test6 () {
        LinkedList listEnd = new LinkedList("listEnd");
        LinkedList listMiddle = new LinkedList("listMiddle",listEnd);
        LinkedList listStart = new LinkedList("listStart",listMiddle);

        assertNotSame(listStart.toString().indexOf("listStart"),-1);
        assertNotSame(listStart.toString().indexOf("listMiddle"),-1);
        assertNotSame(listStart.toString().indexOf("listEnd"),-1);
        /* not found */
        assertSame(listMiddle.toString().indexOf("listStart"),-1);
    }
    @Test
    public void test7 () {
        LinkedList list = new LinkedList();
        assertNull(list.getData());
        list.setData(1000);
        assertEquals(1000,list.getData());
        list.setData("string");
        assertEquals("string",list.getData());
    }
    @Test
    public void test8 () {
        LinkedList[]  lists= new LinkedList[100];
        lists[99] = new LinkedList(99);
        for(int i = 98; i >= 0; i--) {
            lists[i] = new LinkedList(i,lists[i+1]);
        }
        assertEquals(1,lists[99].countAllNextList());
        assertEquals(100,lists[0].countAllNextList());
    }
    @Test
    public void test9 () {
        LinkedList list = new LinkedList(10);
        LinkedList copyList =list.clone();

        assertNotEquals(list.getData(), copyList.getData());
        copyList.setData(10);
        assertEquals(list.getData(), copyList.getData());
    }

    @Test
    public void test10 () {
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
