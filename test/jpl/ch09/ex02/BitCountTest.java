package jpl.ch09.ex02;

import static org.junit.Assert.*;
import org.junit.Test;
import static jpl.ch09.ex02.BitCount.bitCountOf;

public class BitCountTest {

    @Test
    public void test1 () {
        assertEquals(1, bitCountOf(1) );
        assertEquals(1, bitCountOf(2) );
        assertEquals(2, bitCountOf(3) );
        assertEquals(1, bitCountOf(4) );
    }


    @Test
    public void test2 () {
        assertEquals(32, bitCountOf(-1) );
        assertEquals(31, bitCountOf(0x7fffffff) );
    }

}
