package jpl.ch20.ex05;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

public class SearchWordReader {

	public static void main(String[] args) throws IOException {

		serachWord("apple",
		"apple\r\n" +
		"orange\r\n" +
		"pineapple");

	}


	public static void serachWord(String word, String doc) throws IOException {
		StringReader sr = new StringReader(doc);
		LineNumberReader reader = new LineNumberReader(sr);

		String line;
		while((line = reader.readLine()) != null) {
			if(line.indexOf(word) != -1) {
				System.out.println(reader.getLineNumber() + ": " + line);
			}

		}
	}


}
