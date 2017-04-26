package jpl.ch21.ex02;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.WeakHashMap;

public class DataHandler {
	private WeakHashMap<File, byte[]> lastDatas = new  WeakHashMap<File, byte[]>();

	byte[] readFile(File file) {
		byte[] data;

		if(lastDatas.containsKey(file)) {
			data = lastDatas.get(file);
			if(data != null ) {return data; }
		}

		data = readBytesFromFile(file);
		lastDatas.put(file, data);
		return data;
	}

	private byte[] readBytesFromFile(File file) {
		long size = file.length();

		byte[] bytes = new byte[(int) size];
		try {
		    RandomAccessFile raf = new RandomAccessFile(file, "r");
		    try {
		        raf.readFully(bytes);
		    } finally {
		        raf.close();
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return bytes;
	}
}
