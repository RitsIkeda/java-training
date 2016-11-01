package jpl.ch01.ex16;
import java.io.IOException;

public class BadDataSetException extends Exception {
    private IOException e;
    private String dataNames[];

    public BadDataSetException(IOException e,String... datas) {
        super();
        this.dataNames = datas;
        this.e = e;
    }
    public IOException getIOException() {
        return e;
    }
    public String getDataName(int i) {
        if( i >= dataNames.length ) {
            return null;
        } else {
            return dataNames[i];
        }
    }

}
