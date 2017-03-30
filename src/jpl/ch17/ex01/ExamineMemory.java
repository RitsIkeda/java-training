package jpl.ch17.ex01;

public class ExamineMemory {
	private Runtime rt = Runtime.getRuntime();

	ExamineMemory() {

	}
	public void runGC() {
		rt.gc();
	}
	public long getFreeMemory() {
		return rt.freeMemory();
	}
	public void fillMemory(int fillSize, int count) {
		char trash[][] = new char[count][];
		for (int i = 0; i < trash.length; i++) {
			trash[i] = new char[fillSize];
		}
	}

}
