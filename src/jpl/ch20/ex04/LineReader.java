package jpl.ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineReader extends FilterReader {

	protected LineReader(Reader reader) {
		super(reader);
	}

	@Override
	public int read(char[] buff) throws IOException {
		int i = 0;

		while(true) {
			super.read(buff,i,1);
			if( buff[i] == '\n') {
				return i;
			}
			i++;
		}

	}

}
