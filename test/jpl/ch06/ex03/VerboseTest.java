package jpl.ch06.ex03;

import static org.junit.Assert.*;
import org.junit.Test;

public class VerboseTest implements Verbose {
    Level level;
    public void setVerbosity(Level level){
        this.level = level;
    }
    public Level getVerbosity() {
        return level;
    }

    @Test
    public void test1 () {
        VerboseTest verbose = new VerboseTest();
        assertNull(verbose.getVerbosity());
        verbose.setVerbosity(Verbose.Level.SILENT);
        assertEquals(Verbose.Level.SILENT, verbose.getVerbosity());
    }
}
