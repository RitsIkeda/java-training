package java8.ch02.ex03;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public final class CountLongContents {


	public static void main(String[] args) throws IOException {
		String  contents = new String(Files.readAllBytes(Paths.get("src\\java8\\ch02\\ex01\\GettysburgAdress.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		countLongContentsSingle(words,6);
		countLongContentsParallel(words,6);
	}


	public static void countLongContentsSingle(List<String> words , int threshold) {
		long before = System.nanoTime();
		long count = words.stream().filter( w -> w.length() > threshold).count();
		long after = System.nanoTime();

		System.out.println("count:" + count);
		System.out.println("time:" + (after - before));
	}


	public static void countLongContentsParallel(List<String> words, int threshold) {
		long before = System.nanoTime();
		long count = words.parallelStream().filter( w -> w.length() > threshold).count();
		long after = System.nanoTime();

		System.out.println("count:" + count);
		System.out.println("time:" + (after - before));
	}

}
