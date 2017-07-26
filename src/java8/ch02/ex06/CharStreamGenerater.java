package java8.ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class CharStreamGenerater {

	public static void main(String[] args) {
		generate("boat").forEach(System.out::println);
	}

	public static Stream<Character> generate(String string) {
		return IntStream.range(0, string.length()).mapToObj(string::charAt);
	}
}
