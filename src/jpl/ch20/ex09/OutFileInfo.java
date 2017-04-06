package jpl.ch20.ex09;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class OutFileInfo {

	public static void outFileInfo(String path) throws IOException {

		File file = new File(path);
		System.out.println(" **** " + file.getName() + " Info" + " **** ");

		out("getName()",file.getName());
		out("getPath()",file.getPath());
		out("getAbsolutePath()",file.getAbsolutePath());
		out("getCanonicalPath()",file.getCanonicalPath());
		out("getParent()",file.getParent());

		out("exists()",file.exists());
		out("canRead()",file.canRead());
		out("canWrite()",file.canWrite());
		out("canWrite()",file.canWrite());
		out("isDirectory()",file.isDirectory());
		out("isAbsolute()",file.isAbsolute());
		out("isHidden()",file.isHidden());


		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		out("lastModified()",sdf.format(file.lastModified()));
		out("length()",file.length());
		String[] list = file.list();
		if( list != null ) {
			for(int i = 0; i < list.length; i++) {
				 out( "file.list()[" + i + "]", list[i]);
			}

		}
		System.out.println();
	}

	public static void outFileInfo(String[] pathes) throws IOException {
		for( String path : pathes) {
			outFileInfo(path);
		}
	}
	private static void out(String label, long value) {
		System.out.println(label + " = " + value);

	}
	private static void out(String label, String value) {
		System.out.println(label + " = " + value);
	}
	private static void out(String label, boolean value) {
		System.out.println(label + " = " + value);

	}
	public static void main(String args[]) throws IOException {
		outFileInfo("src" + File.separator + "jpl" + File.separator + "ch20" + File.separator + "ex09" + File.separator + "OutFileInfo.java");
		outFileInfo("src" + File.separator + "jpl" + File.separator + "ch20" + File.separator + "ex09" + File.separator);
	}

}
