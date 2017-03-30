package jpl.ch17.ex02;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;

public class DataHandler {

	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;


	byte[] readFile(File file) {
		byte[] data;

		if(file.equals(lastFile)) {
			data = lastData.get();
			if(data != null)
				return data;
		}

		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
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
