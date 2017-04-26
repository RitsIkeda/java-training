package jpl.ch22.ex11;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

	public static List<String[]> readCSV(String source, int cellCount) throws IOException {


		StreamTokenizer in = new StreamTokenizer( new StringReader(source));
		in.wordChars(0, 0xffff);
		in.whitespaceChars(',',',');

		List<String[]> result = new  ArrayList<String[]>();

		while(in.nextToken() != StreamTokenizer.TT_EOF) {
			String[] line = new String[cellCount];
			for(int i = 0; i < cellCount; i++) {

				if(in.ttype ==  StreamTokenizer.TT_NUMBER) {
					line[i] = String.valueOf( in.nval );
				} else {
					line[i] = in.sval;
				}
				if( i < cellCount - 1) {
					in.nextToken();
				}
			}
			result.add(line);
		}
		return result;
	}

	static int countChar(String target, char c ) {
		int count = 0;
		for(int i = 0; i < target.length(); i++ ) {
			if(target.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public static void out(List<String[]> list) {
		 for(String[] line : list) {
			 for(String str : line) {
				 System.out.print(str + "/");
			 }
			 System.out.println();
		 }

	}

	public static void main(String args[]) throws IOException {

		List<String[]> result;

		result = readCSV("1, 2,3,\r\n"
				+ "A, B,C,\r\n"
				+ "い, ろ,は,\r\n"
				, 3);

		out(result);
	}

}
