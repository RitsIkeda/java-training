package jpl.ch20.ex03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DecryptInputStream extends FilterOutputStream {

	private Byte mask;
	public Byte getMask() {
		return mask;
	}

	private DecryptInputStream(OutputStream out) {
		super(out);
	}
	public DecryptInputStream(OutputStream arg0, EncryptOutputStream encrypter) {
		this(arg0);
		this.mask = encrypter.getMask();
	}
	public void decrypt(byte[] b) throws IOException {
		this.write(b);
	}

	@Override
	public void write(int b) throws IOException {
		super.write(b ^ mask);
	}

	@Override
	public void write(byte[] b) throws IOException {

		byte[] convertedByte = new byte[b.length];
		for(int i = 0;  i < b.length; i++) {
			convertedByte[i] = b[i];
		}
		super.write(b);

	}
}
