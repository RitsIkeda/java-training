package jpl.ch21.ex06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Concat implements Enumeration<FileInputStream> {

	private List<String> fileNames;
	private int index = 0;

	Concat(String[] names) {
		fileNames = new ArrayList<String>(names.length);

		for(String name: names) {
			fileNames.add(name);
		}
	}


	@Override
	public boolean hasMoreElements() {
		return  (index < fileNames.size());
	}

	@Override
	public FileInputStream nextElement() {
		FileInputStream result;
		try {
			result = new FileInputStream(fileNames.get(index++));
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}


}
