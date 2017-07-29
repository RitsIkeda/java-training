package java8.ch03.ex20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public final class ListConverter {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<Double> doubles = map(ints, i -> i * 1.111111);
		for(Double d : doubles) {
			System.out.println(d);
		}

	}

	public static <T, U> List<U> map(List<T> base, Function<T,U> converter) {
		ArrayList<U> result = new ArrayList<U>();
		for(T t: base ) {
			result.add(converter.apply(t));
		}
		return result;
	}

}
