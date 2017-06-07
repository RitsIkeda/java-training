package java8.ch01.ex04;

import java.io.File;
import java.util.Arrays;

public class SortFiles {

	public static void main(String[] args) {

		File root = new  File("src\\interpret");
		File newDir1 = new  File(root.getPath() + "\\dir1");
		File newDir2 = new  File(root.getPath() + "\\dir2");
		newDir1.mkdir();
		newDir2.mkdir();

		File[] files = sortFiles(root);
		for(File f : files) {
			System.out.println(f);
		}

		newDir1.delete();
		newDir2.delete();
	}


	public static File[] sortFiles(File root) {
		File[] files = root.listFiles();
		Arrays.sort(files, (first, second) -> {
			if(first.isDirectory() && second.isFile()) {
				return -1;
			}
			if(first.isFile() && second.isDirectory()) {
				return 1;
			}
			return first.getPath().compareTo(second.getPath());
		});
		return files;
	}

}
