package jpl.ch01.ex15;

import static org.junit.Assert.*;
import org.junit.Test;

public class ImplementedLookUpTest {

    @Test
    public void test1 () {
        ImplementedLookUp table = new ImplementedLookUp();
        assertNull(table.find("name"));
    }
    @Test
    public void test2() {
        ImplementedLookUp table = new ImplementedLookUp();
        table.add("apple","Apple");
        assertEquals("Apple",table.find("apple"));
        assertNull(table.find("orange"));
    }
    @Test
    public void test3 () {
        ImplementedLookUp table = new ImplementedLookUp();
        for(int i = 0; i < 100; i += 2 ) {
            table.add("name" + String.valueOf(i),i);
        }
        assertEquals(0,table.find("name0"));
        assertEquals(98,table.find("name98"));
        assertNull(table.find("name1"));
        assertNull(table.find("name100"));

        assertEquals(50,table.find("name50"));
        table.remove("name50");
        assertNull(table.find("name50"));
    }
}
