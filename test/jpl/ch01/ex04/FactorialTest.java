package jpl.ch01.ex04;

import static org.junit.Assert.*;
import org.junit.Test;

public class FactorialTest {

    /* Normal Case */
    @Test
    public void test1 () {
        assertEquals(1,Factorial.calcFactorial(1));
        assertEquals(2,Factorial.calcFactorial(2));
        assertEquals(120,Factorial.calcFactorial(5));
        assertEquals(3628800,Factorial.calcFactorial(10));
    }

    /* Extreme Case */
    @Test
    public void test2 () {
        assertEquals(1,Factorial.calcFactorial(-1));
        assertEquals(1,Factorial.calcFactorial(0));
        assertEquals(2432902008176640000L,Factorial.calcFactorial(20));
    }
}
