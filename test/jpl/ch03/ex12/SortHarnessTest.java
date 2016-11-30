package jpl.ch03.ex12;

import static org.junit.Assert.*;
import org.junit.Test;


public class SortHarnessTest extends SortHarness  {

    protected void doSort() {
        for(int i = 0; i < getDataLength(); i ++) {
            for(int j  = i + 1; j < getDataLength(); j++) {
                    if(compare(i,j) > 0) {
                        swap(i ,j);
                    }
            }
        }
    }
    @Test
    public void test1 () {
        Object[] testData = { 4, "dog", 1.4, new double[5], new int[4], new Exception() };
        SortHarnessTest sortHarness = new SortHarnessTest();
        sortHarness.sort(testData);
        Object[] resultValues = sortHarness.getValues();

        assertTrue( resultValues[0].hashCode() < resultValues[1].hashCode() );
        assertTrue( resultValues[1].hashCode() < resultValues[2].hashCode() );
        assertTrue( resultValues[2].hashCode() < resultValues[3].hashCode() );
        assertTrue( resultValues[3].hashCode() < resultValues[4].hashCode() );
        assertTrue( resultValues[4].hashCode() < resultValues[5].hashCode() );
    }

    @Test
    public void test2 () {
        Object[] testData = { 1, 2, 3, 5, 4 };
        SortHarnessTest sortHarness = new SortHarnessTest();
        SortMetrics metrix = sortHarness.sort(testData);

        assertEquals(0, metrix.probeCnt());
        assertEquals(1, metrix.swapCnt());
        assertEquals(10, metrix.compareCnt());
    }

}
