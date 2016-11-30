package jpl.ch03.ex11;

/* 練習問題 3.11
 2つのセキュリティーホールがある。
 1.
 sortで渡される配列はディープコピーして渡し、
 配列をとるためのgetメソッドを用意すべき。
 ソート中に別のメソッドが配列の中身を書き換える可能性がある。
 2.
　ソートメトリックスのメンバ変数はprivateであるべき。
　ソートアルゴリズムのサブラスが自由に書き換えできてしまう。 */
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


abstract class SortDouble {
    private double values[];
    private final SortMetrics curMetrics = new SortMetrics();

    public final SortMetrics sort(double[] data) {
        values = data.clone(); /* ディープコピーにすべき */
        curMetrics.init();
        doSort();
        return getMetrics();
    }
    public final double[] getValues() {
        return values.clone();
    }
    public final SortMetrics getMetrics() {
        return curMetrics.clone();
    }
    public final int getDataLength() {
        return values.length;
    }
    protected final double probe(int i) {
        curMetrics.incrementProbeCnt();
        return values[i];
    }
    protected final int compare(int i, int j) {
        curMetrics.incrementCompareCnt();
        double d1 = values[i];
        double d2 = values[j];
        if(d1 == d2) {
            return 0;
        } else {
            return (d1 < d2 ? -1 : 1);
        }
    }
    protected final void swap(int i, int j) {
        curMetrics.incrementSwapCnt();
        double tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
    protected abstract void doSort();

}
