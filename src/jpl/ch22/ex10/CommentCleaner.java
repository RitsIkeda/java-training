package jpl.ch22.ex10;

import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

public class CommentCleaner {


	public static void removeComment(Reader source) {
		try (Scanner in = new Scanner(source)) {
			in.useDelimiter("#.*\n");

			while(in.hasNext()) {
				System.out.println(in.next());
			}
		}
	}

	public static void main(String[] args) {
		removeComment(new  StringReader("token\n"
				+ "# This is a comment"
				+ "\ntoken2"));

		removeComment(new  StringReader("token\n"
				+ "#comment1 #comment2"
				+ "\ntoken2 #comment3"
				+ "\ntoken3"));

	}
}

