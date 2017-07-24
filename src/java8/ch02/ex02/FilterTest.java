package java8.ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class FilterTest {



	public static void main(String[] args) throws IOException {
		String  contents = new String(Files.readAllBytes(Paths.get("src\\java8\\ch02\\ex01\\GettysburgAdress.txt")), StandardCharsets.UTF_8);
		filterTest(contents, 5,5);
	}

	public static void filterTest(String  contents , int threshold, int limit) {

		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		words.stream().filter( w -> {
			if ( w.length() > threshold ) {
				System.out.println("★[LONG] " + w);
				return true;
			} else {
				System.out.println("[short] " + w);
				return false;
			}
		}).limit(limit).count();
	}

}
