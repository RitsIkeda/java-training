package java8.ch02.ex13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ShortWordsCounter {

	public static void main(String[] args) throws IOException {

		String contents = new String(Files.readAllBytes(Paths.get("src\\java8\\ch02\\ex01\\GettysburgAdress.txt")), StandardCharsets.UTF_8);

		for(int i = 0; i < 10; i++)
		{
			Stream<String> words = Arrays.asList(contents.split("[\\P{L}]+")).stream();
			 Map<Integer, Long> map = countShortWords(words, 12);
			for(int j =0; j < 12; j++ ) {
				long count = map.get(j) == null ? 0 : map.get(j);
				System.out.print(count + ",");
			}
			System.out.println();
		}
	}


	public static  Map<Integer, Long> countShortWords(Stream<String> words, int limit) {

		 Map<Integer, Long> map = words.parallel().filter(s -> s.length() < limit).
				 collect(Collectors.groupingBy(String::length, Collectors.counting()));

		return map;
	}

}
