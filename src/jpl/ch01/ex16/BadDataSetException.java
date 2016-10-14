package jpl.ch01.ex16;
import java.io.IOException;

class BadDataSetException extends Exception {
    IOException e;
    String dataNames[];

    BadDataSetException(IOException e,String... datas) {
        super();
        this.dataNames = datas;
        this.e = e;
    }
}
