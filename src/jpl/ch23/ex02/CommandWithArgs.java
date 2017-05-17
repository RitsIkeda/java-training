package jpl.ch23.ex02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CommandWithArgs {

	public static void main(String[] args) {

		// mainMtehod(args); // コンソールから実行する場合
		String[] testArgs = {"src\\jpl\\ch23\\ex02\\GetRandomFruits.exe" , "30"};
		mainMtehod(testArgs);
	}

	public static void mainMtehod(String[] args) {
		try {
			Process proc = new ProcessBuilder(args).redirectErrorStream(true).start();
			plugTogether(System.in, proc.getOutputStream());
			plugTogether(System.out, proc.getInputStream());
			plugTogether(System.err, proc.getErrorStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void plugTogether(OutputStream parent, InputStream child) {
		new Thread(new Runnable() {
			public void run() {
				int c, line = 1;
				String lineStr;
				boolean newLineFlag = true;

				try {
					//parent.write(lineStr.getBytes());
					while((c = child.read()) != - 1) {
						if(newLineFlag) {
							lineStr = line++ + ": ";
							parent.write(lineStr.getBytes());
							newLineFlag = false;
						}
						parent.write(c);
						if(c == '\n') {
							newLineFlag = true;

						}
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
