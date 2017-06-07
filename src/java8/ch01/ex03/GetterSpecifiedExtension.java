package java8.ch01.ex03;

import java.io.File;

public class GetterSpecifiedExtension {

	public static void main(String args[]) {
		File folder = new File("src\\interpret");
		{
			File[] files = getSpecifiedExtension(folder, "java");
			for(File f : files) {
				System.out.println(f);
			}
		}
	}

	public static File[] getSpecifiedExtension(File file, String extention ) {
		/* エンクロージングクラスからスコープされる変数は、extention */
		return file.listFiles(f -> f.isFile() && f.getPath().endsWith( "." + extention));

	}
}