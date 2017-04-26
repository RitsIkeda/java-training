package jpl.ch22.ex03;

import java.util.BitSet;
import java.util.HashMap;

public class WhichChars {

	private HashMap<Byte, BitSet> used = new HashMap<Byte,BitSet>();

	public WhichChars(String str) {
		for(int i = 0; i < str.length(); i++) {
			int c = str.charAt(i);
			byte upper = (byte) ((0xff00 & c) >> 8);
			int lower = (0x00ff & c);

			BitSet bitset ;
			if(used.containsKey(upper)) {
				bitset = used.get(upper);
			} else {
				bitset = new BitSet();
			}
			bitset.set(lower);
			used.put(upper, bitset);
		}
	}
	public String toString() {
		String result = "[";

		for(byte upper : used.keySet()) {
			BitSet used = this.used.get(upper);
			upper <<= 8;

			for(int i = used.nextClearBit(0);
					i >= 0;
					i = used.nextSetBit(i + 1) ) {
				result += (char) (upper | i);
			}
		}

		return result + "]";
	}
	public static void main(String[] args) {
		WhichChars chars = new WhichChars("Testing 1 2 3");
		System.out.println(chars);
	}
}
