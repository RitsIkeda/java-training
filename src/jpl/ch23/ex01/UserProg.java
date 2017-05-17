package jpl.ch23.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class UserProg {

	public static void userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
	}


	public static void main(String args[])  {
		try {
			userProg("src\\jpl\\ch23\\ex01\\HelloWorld.exe");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	private static void plugTogether(OutputStream parent, InputStream child) {
		new Thread(new Runnable() {
			public void run() {
				int c;
				try {
					while((c = child.read()) != - 1) {
						parent.write(c);
					}
				} catch (IOException e) {
					/* app Close */
				}

			}
		}).start();
	}

	private static void plugTogether(InputStream parent, OutputStream child) {
		new Thread(new Runnable() {
			public void run() {

				int c;
				try{
					while((c = (char) parent.read()) != - 1) {
						child.write(c);
						child.flush();
					}
				}
				catch (IOException e) {
					/* app Close */
				}
			}
		}).start();
	}

}
