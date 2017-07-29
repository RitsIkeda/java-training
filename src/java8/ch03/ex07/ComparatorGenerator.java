package java8.ch03.ex07;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorGenerator {

	static public void main(String[] args) {

		String[] strs = { "red", "grren", "blue", "Red", "Grren", "Blue", " space" };

		Arrays.sort(strs,generate(false, true, false));
		print(strs);
		Arrays.sort(strs,generate(true, true, false));
		print(strs);
		Arrays.sort(strs,generate(false, false, false));
		print(strs);
		Arrays.sort(strs,generate(false, true, true));
		print(strs);
	}
	public static void print(String[] strs) {
		for(int i = 0; i < strs.length; i++) {
			System.out.print( strs[i] + ",");
		}
		System.out.println();
	}

	public static Comparator<String> generate(boolean reverse, boolean caseDistinction, boolean excludeSpase ) {

		return (s1, s2) -> {
			if(!caseDistinction) {
				s1 = s1.toLowerCase();
				s2 = s2.toLowerCase();
			}
			if(excludeSpase) {
				s1 = s1.trim();
				s2 = s2.trim();
			}
			return reverse ? s2.compareTo(s1) : s1.compareTo(s2);

		};
	}

}
