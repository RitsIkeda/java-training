package java8.ch02.ex12;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public final class ShortWordsCounter {

	public static void main(String[] args) throws IOException {

		String contents = new String(Files.readAllBytes(Paths.get("src\\java8\\ch02\\ex01\\GettysburgAdress.txt")), StandardCharsets.UTF_8);

		for(int i = 0; i < 10; i++)
		{
			Stream<String> words = Arrays.asList(contents.split("[\\P{L}]+")).stream();
			AtomicInteger[] count = countShortWords(words, 12);
			for(AtomicInteger integer : count ) {
				System.out.print(integer + ",");
			}
			System.out.println();
		}

	}


	public static AtomicInteger[] countShortWords(Stream<String> words, int limit) {
		AtomicInteger[] counter = new AtomicInteger[limit];
		for(int i = 0; i < limit; i++) {
			counter[i] = new AtomicInteger(0);
		}
		words.parallel().forEach(s -> { if(s.length() < limit) {
			counter[s.length()].getAndIncrement();
		}});
		return counter;
	}

}
