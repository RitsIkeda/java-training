package java8.ch02.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class Zip {

	public static void main(String[] args) {


		Stream<Character> first = Stream.of('A','B','C','D','E', 'F' );
		Stream<Character> second = Stream.of('a','b','c','d' );

		zip(first,second).forEach(System.out::println);

	}

	@SuppressWarnings("unchecked")
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		Object[] firstArray = first.toArray();
		Object[] secondArray = second.toArray();

		List<T> zippedList = new ArrayList<T>();

		for(int i = 0; i < firstArray.length; i++ ) {
			zippedList.add((T) firstArray[i]);
			if(i >= secondArray.length) { break; }
			zippedList.add((T) secondArray[i]);
		}
		return zippedList.stream();
	}
}
