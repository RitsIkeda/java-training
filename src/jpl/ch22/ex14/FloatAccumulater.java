package jpl.ch22.ex14;

import java.util.StringTokenizer;

public class FloatAccumulater {

	public static double accumulate(String source) {

		StringTokenizer tokenizer = new StringTokenizer(source, " ");
		double result = 0;

		while(tokenizer.hasMoreTokens()) {
			result += Double.parseDouble( tokenizer.nextToken() );
		}
		return result;
	}


}
