package jpl.ch20.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {

	public static void translateByte(InputStream in, byte from, byte to, OutputStream out) throws IOException {

		int b;
		while( (b = in.read()) != -1) {
			out.write(b == from ? to : b );
		}
	}

	public static void main(String[] args) {

		byte from ,to;
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
			translateByte(System.in, from, to, System.out);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
