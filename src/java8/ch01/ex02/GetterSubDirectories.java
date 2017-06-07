package java8.ch01.ex02;

import java.io.File;

public final class GetterSubDirectories {

	public static void main(String args[]) {
		File folder = new File("src");
		{
			File[] folders = getSubDirectories(folder, true);
			for(File f : folders) {
				System.out.println(f);
			}
		}
		{
			File[] folders = getSubDirectories(folder, false);
			for(File f : folders) {
				System.out.println(f);
			}
		}
	}


	public static File[] getSubDirectories(File folder, boolean useMethodRef) {
		return useMethodRef ?
				folder.listFiles(File::isDirectory) :
				folder.listFiles((file) -> file.isDirectory());
	}
}
