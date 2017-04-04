package jpl.ch20.ex02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByte extends FilterReader {

	private static byte from;
	private static byte to;

	protected TranslateByte(Reader arg0) {
		super(arg0);
	}

	public void translateByte(OutputStream out) throws IOException {
		int b;
		while( (b = this.read()) != -1) {
			out.write(b);
		}
		out.flush();
	}

	public static void main(String[] args) {

		switch (args.length) {
		case 0:
			from = 'l';
			to = '!';
			break;

		case 1:
			from = (byte) args[0].charAt(0);
			to = 'l';
			break;

		default:
			from = (byte) args[0].charAt(0);
			to = (byte) args[1].charAt(0);
			break;
		}

		try {
			StringReader sr;
			if(args.length < 0) {
			 	sr = new StringReader(args[0]);
			} else {
				sr = new StringReader("FilterReader");
			}
			 TranslateByte tb = new TranslateByte(sr);
			 tb.translateByte(System.out);
			 tb.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public int read() throws IOException {
		int c;
		c = super.read();
		if(c == from) {
			c = to;
		}
		return c;
	}


}

