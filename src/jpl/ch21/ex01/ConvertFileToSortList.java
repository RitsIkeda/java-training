package jpl.ch21.ex01;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import jpl.ch20.ex04.LineReader;


public class ConvertFileToSortList {
	LineReader reader;

	public ConvertFileToSortList(LineReader reader) {
		this.reader = reader;
	}
	public ConvertFileToSortList(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		this.reader = new LineReader(reader);
	}

	LinkedList<String> convertFileToSortList() throws IOException {

		LinkedList<String> result = new LinkedList<String>();
		while(true) {
			char buff[] = new char[256];
			int p = reader.read(buff);
			if(p == -1) {
				break;
			}
			result.add(String.valueOf( buff));
		}

		Collections.sort( result, new Comparator<String>(){
	        @Override
	        public int compare(String a, String b){
	          return a.compareTo(b);
	        }
	    });
		return result;
	}


	public static void main(String[] args) throws IOException {
//1
//3
//2
//5
//4
//0
		ConvertFileToSortList reader = new ConvertFileToSortList("src" + File.separator + "jpl" + File.separator + "ch21" + File.separator + "ex01"
			+ File.separator + "ConvertFileToSortList.java");
		LinkedList<String> list = reader.convertFileToSortList();

		for(String line: list ) {
			System.out.print(line);
		}

	}

}
