package jpl.ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class LineReader extends FilterReader {

	protected LineReader(Reader reader) {
		super(reader);
	}

	@Override
	public int read(char[] buff) throws IOException {
		int i = 0;

		while(super.read(buff,i,1) != -1) {

			if( buff[i] == '\n') {
				return i;
			}
			i++;
		}
		return -1;
	}

	public static void main(String args[]) {

		StringReader reader = new StringReader(
				"line1" + System.getProperty("line.separator") +
				"ライン２" + System.getProperty("line.separator") +
				"３行目" + System.getProperty("line.separator"));

		try (
			LineReader filter = new LineReader(reader);
		) {
			for(int i = 0; i < 3; i++) {
				char[] buff = new char[128];
				filter.read(buff);
				System.out.print(buff);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
