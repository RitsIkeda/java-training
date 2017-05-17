package jpl.ch23.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CommandWithArgsTillApp {

	private static final String endStr = "app";
	Process proc;

	public static void main(String[] args) {

		// mainMtehod(args); // コンソールから実行する場合
		String[] testArgs = {"src\\jpl\\ch23\\ex02\\GetRandomFruits.exe" , "30"};
		new CommandWithArgsTillApp().mainMtehod(testArgs);
	}

	public CommandWithArgsTillApp() {

	}

	public void mainMtehod(String[] args) {
		try {
			proc = new ProcessBuilder(args).redirectErrorStream(true).start();
			plugTogether(System.in, proc.getOutputStream());
			plugTogether(System.out, proc.getInputStream());
			plugTogether(System.err, proc.getErrorStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void plugTogether(OutputStream parent, InputStream child) {
		new Thread(new Runnable() {
			public void run() {
				int c, lineNo = 1;
				String buff = "", lineStr;
				boolean newLineFlag = true;

				try {
					//parent.write(lineStr.getBytes());
					while((c = child.read()) != - 1) {
						if(newLineFlag) {
							lineStr = lineNo++ + ": ";
							parent.write(lineStr.getBytes());
							newLineFlag = false;
						}
						parent.write(c);
						buff += (char) c;

						if(buff.contains(endStr)) {
							parent.flush();
							proc.destroy();
							System.exit(0);
						}
						if(c == '\n') {
							newLineFlag = true;
							buff = "";
						}
					}
				} catch (IOException e) {
					/* app Close */
				}
			}
		}).start();
	}

	private void plugTogether(InputStream parent, OutputStream child) {
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
