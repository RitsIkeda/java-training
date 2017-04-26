package jpl.ch22.ex07;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ReadCSV {

	public static List<String[]> readCSV(Readable source, int cellCount) throws IOException {
		if(cellCount < 1) {
			throw new IllegalArgumentException();
		}

		try ( Scanner in = new Scanner(source) ) {

			String exp = "^";
			for(int i = 0; i < cellCount - 1; i++) {
				exp += "(.*)" + ",";
			}
			exp += "(.*)";

			List<String[]> vals = new ArrayList<String[]>();

			Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
			while(in.hasNextLine()) {
				String line = in.findInLine(pat);
				if(line == null) {
					throw new IOException("input format Error");
				}
				String[] cells = new String[cellCount];
				MatchResult match = in.match();
				for(int i = 0; i < cellCount; i++) {
					cells[i] = match.group(i + 1);
				}
				vals.add(cells);
				in.nextLine(); //skip NewLine
			}

			IOException ex = in.ioException();
			if(ex != null) {
				throw ex;
			}
			return vals;
		}
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
		StringReader reader = new  StringReader(
				"A,B,C,D,E\n" +
				"AA,BB,CC,DD,EE\n" +
				"AAA,BBB,CCC,DDD,EEE\n");
		 List<String[]> result = readCSV(reader, 5);
		 out(result);

		reader = new  StringReader(
					"1,2,3\n" +
					"1.1,2.2,3.3\n" +
					"0.1,0.2,0.3\n");
		result = readCSV(reader, 3);
		out(result);

	}

}
