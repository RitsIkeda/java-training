package java8.ch02.ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public final class ArrayListMerger {

	public static void main(String[] args) {

		for ( String str : merge1(Stream.of(
				new ArrayList<String>(Arrays.asList( "1," ,"2,", "3," )),
				new ArrayList<String>(Arrays.asList( "4," ,"5,", "6," )),
				new ArrayList<String>(Arrays.asList( "7," ,"8,", "9," ))
				)) ) {
			System.out.print(str);
		}
		System.out.println();
		for ( String str : merge2(Stream.of(
				new ArrayList<String>(Arrays.asList( "1," ,"2,", "3," )),
				new ArrayList<String>(Arrays.asList( "4," ,"5,", "6," )),
				new ArrayList<String>(Arrays.asList( "7," ,"8,", "9," ))
				)) ) {
			System.out.print(str);
		}
		System.out.println();
		for ( String str : merge3(Stream.of(
				new ArrayList<String>(Arrays.asList( "1," ,"2,", "3," )),
				new ArrayList<String>(Arrays.asList( "4," ,"5,", "6," )),
				new ArrayList<String>(Arrays.asList( "7," ,"8,", "9," ))
				)) ) {
			System.out.print(str);
		}
		System.out.println();


	}

	public static <T> ArrayList<T> merge1(Stream<ArrayList<T>> stream) {

		Optional<ArrayList<T>> optional = stream.reduce(
				(ArrayList<T> first, ArrayList<T> second) -> {
					first.addAll(second);
					return first;
					});
		return optional.get();
	}

	public static <T> ArrayList<T> merge2(Stream< ArrayList<T>> stream) {
		return stream.reduce(new ArrayList<T>(),
				(ArrayList<T> first, ArrayList<T> second) -> {
					first.addAll(second);
					return first;
					});
	}

	public static <T> ArrayList<T> merge3(Stream< ArrayList<T>> stream) {
		return stream.reduce(
		        new ArrayList<T>(),
		        (ArrayList<T> first, ArrayList<T> second) -> {
					first.addAll(second);
					return first;
					},
		        (ArrayList<T> first, ArrayList<T> second) -> {
					first.addAll(second);
					return first;
					}
				);
	}
}

