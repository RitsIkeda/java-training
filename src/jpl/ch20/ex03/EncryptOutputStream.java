package jpl.ch20.ex03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncryptOutputStream extends FilterInputStream {

	private byte mask;
	public void setMask(byte mask) {
		this.mask = mask;
	}
	public byte getMask() {
		return mask;
	}

	protected EncryptOutputStream(InputStream arg0) {
		super(arg0);
	}

	public byte encrypt(byte target) throws IOException {
		byte[] bs = new byte[1];
		bs[0] = target;
		this.read(bs, 0, 1);
		return bs[0];
	}
	public void encrypt(byte[] targets) throws IOException {
		this.read(targets, 0, 1);
	}

	@Override
	public int read() throws IOException {
		return mask ^ super.read();
	}
	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int nread = super.read(b, off, len);
		int last = off + nread;

		for(int i = off; i < last; i++) {
			b[i] = (byte) (mask ^ b[i]);
		}
		return nread;
	}
}
