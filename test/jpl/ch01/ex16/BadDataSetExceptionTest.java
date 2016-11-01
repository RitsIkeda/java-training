package jpl.ch01.ex16;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;

public class BadDataSetExceptionTest {

    @Test
    public void test1 () {
        IOException ioExeption = new IOException("IOException1");
        boolean catched = false;

        try {
            throw new BadDataSetException(ioExeption,"message1");
        } catch (BadDataSetException e) {
            catched = true;
            assertEquals(e.getIOException().getMessage(), "IOException1" );
            assertEquals(e.getDataName(0), "message1" );
        } finally {
            assertTrue(catched);
        }
    }
    @Test
    public void test2 () {
        IOException ioExeption = new IOException("IOException2");
        boolean catched = false;

        try {
            throw new BadDataSetException(ioExeption,"message1","message2","message3");
        } catch (BadDataSetException e) {
            catched = true;
            assertEquals(e.getIOException().getMessage(), "IOException2" );
            assertEquals(e.getDataName(0), "message1" );
            assertEquals(e.getDataName(1), "message2" );
            assertEquals(e.getDataName(2), "message3" );
            assertNull(e.getDataName(3));
        }
    }
}
