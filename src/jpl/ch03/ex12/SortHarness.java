package jpl.ch03.ex12;

abstract class SortHarness {
    private Object values[];
    protected final int compare(int i, int j) {
        curMetrics.incrementCompareCnt();
        return values[i].hashCode() - values[j].hashCode();
    }

    private final SortMetrics curMetrics = new SortMetrics();

    public final SortMetrics sort(Object[] data) {
        values = data.clone();
        curMetrics.init();
        doSort();
        return getMetrics();
    }
    protected final Object[] getValues() {
        return values.clone();
    }
    public final SortMetrics getMetrics() {
        return curMetrics.clone();
    }
    public final int getDataLength() {
        return values.length;
    }
    protected final Object probe(int i) {
        curMetrics.incrementProbeCnt();
        return values[i];
    }
    protected final void swap(int i, int j) {
        curMetrics.incrementSwapCnt();
        Object tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
    protected abstract void doSort();
}


class SortMetrics implements Cloneable {
    private long probeCnt, compareCnt, swapCnt;

    public void init() {
        probeCnt = compareCnt = swapCnt = 0;
    }
    public String toString() {
        return probeCnt + " probeCnt"
            + compareCnt + " compareCnt"
            + swapCnt + " swapCnt";
    }

    public SortMetrics clone() {
        try {
            return (SortMetrics) super.clone();
        } catch( CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
    public long probeCnt() {
        return probeCnt;
    }
    public long swapCnt() {
        return swapCnt;
    }
    public long compareCnt() {
        return compareCnt;
    }
    public void incrementProbeCnt() {
        probeCnt++;
    }
    public void incrementSwapCnt() {
        swapCnt++;
    }
    public void incrementCompareCnt() {
        compareCnt++;
    }
}
