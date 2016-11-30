package jpl.ch03.ex11;

import static org.junit.Assert.*;
import org.junit.Test;


public class SortDoubleTest extends SortDouble  {

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
        double[] testData = { 4, 2.5, 124, -24.2, 4e100, -3e100, 0 };
        SortDoubleTest sortDouble = new SortDoubleTest();
        sortDouble.sort(testData);
        double[] resultValues = sortDouble.getValues();

        assertTrue( resultValues[0] < resultValues[1] );
        assertTrue( resultValues[1] < resultValues[2] );
        assertTrue( resultValues[2] < resultValues[3] );
        assertTrue( resultValues[3] < resultValues[4] );
        assertTrue( resultValues[4] < resultValues[5] );
        assertTrue( resultValues[5] < resultValues[6] );
    }

    @Test
    public void test2 () {
        double[] testData = { 1, 2, 3, 5, 4 };
        SortDoubleTest sortDouble = new SortDoubleTest();
        SortMetrics metrix = sortDouble.sort(testData);

        assertEquals(0, metrix.probeCnt());
        assertEquals(1, metrix.swapCnt());
        assertEquals(10, metrix.compareCnt());
    }

}
