package jpl.ch22.ex02;

import java.util.HashSet;
import java.util.Iterator;

public class WhichChars {

	private HashSet<Integer> used = new HashSet<Integer>();

	public WhichChars(String str) {
		for(int i = 0; i < str.length(); i++) {
			used.add((int)str.charAt(i));
		}
	}
	public String toString() {
		String result = "[";
		Iterator<Integer> iterator = used.iterator();
		while(iterator.hasNext()) {
			int i = iterator.next();
			result += (char) i;
		}

		return result + "]";
	}
	public static void main(String[] args) {
		WhichChars chars = new WhichChars("Testing 1 2 3");
		System.out.println(chars);
	}
}
