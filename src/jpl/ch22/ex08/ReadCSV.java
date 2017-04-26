package jpl.ch22.ex08;

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
				} else if( countChar(line, ',') > cellCount ) {
					throw new IOException("Cell Num is wrong.");
				}

				String[] cells = new String[cellCount];
				MatchResult match = in.match();
				for(int i = 0; i < cellCount; i++) {
					cells[i] = match.group(i + 1);
				}
				vals.add(cells);
				if(!in.hasNextLine()) {
					break;
				}
				in.nextLine(); //skip NewLine
			}

			IOException ex = in.ioException();
			if(ex != null) {
				throw ex;
			}
			return vals;
		}
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

		StringReader reader;
		 List<String[]> result;

		try {
			reader = new  StringReader(
					"A,B,C,D,E\n" +
					"AA,BB,CC,DD,EE,FF,\n" +
					"AAA,BBB,CCC,DDD,EEE\n");
			result = readCSV(reader, 5);
		 out(result);
		} catch(IOException e) {
			System.out.println("IOException cathched " + e.getMessage());
		}
		reader = new  StringReader(
					"1,2,3\n" +
					"1.1,2.2,3.3\n" +
					"0.1,0.2,0.3");
		result = readCSV(reader, 3);
		out(result);
	}

}
