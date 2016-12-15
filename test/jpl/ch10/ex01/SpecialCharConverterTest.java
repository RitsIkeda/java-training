package jpl.ch10.ex01;

import static org.junit.Assert.*;
import org.junit.Test;
import static jpl.ch10.ex01.SpecialCharConverter.convertSpecialChar;

public class SpecialCharConverterTest {

    @Test
    public void test1 () {
        String test1 = convertSpecialChar( "test" + (char) 0x027 + "one" );
        System.out.println(test1);

        assertTrue(test1.equals("test\'one"));
    }



}
