package jpl.ch09.ex02;

public class BitCount {

    public static int bitCountOf(int value) {
        int count = 0;
        while(value != 0x0000) {
            count += value & 0x001;
            value >>>= 1;
        }
        return count;
    }
}
