package jpl.ch03.ex07;

import static org.junit.Assert.*;
import org.junit.Test;

public class ColorAttrTest {

    @Test
    public void test1 () {
        ColorAttr bigRed = new ColorAttr("RED", ScreenColor.RED );
        ColorAttr smallRed = new ColorAttr("red", ScreenColor.RED);
        ColorAttr dummyRed = new ColorAttr("RED", ScreenColor.BLUE);

        assertTrue( bigRed.equals(smallRed));
        assertFalse( bigRed.equals(dummyRed));
    }

    @Test
    public void test2() {
        ColorAttr bigRed = new ColorAttr("RED", ScreenColor.RED );
        ColorAttr smallRed = new ColorAttr("red", ScreenColor.RED);
        ColorAttr dummyRed = new ColorAttr("RED", ScreenColor.BLUE);

        assertEquals( bigRed.hashCode(), smallRed.hashCode());
        assertNotEquals( bigRed.hashCode(), dummyRed.hashCode());
    }
}
