package java8.ch02.ex05;

import java.util.stream.Stream;

public final class RandomNumberGenerator {

	public static void main(String[] args) {


		generate(System.currentTimeMillis(), 1025, 2111, 4096).limit(10).forEach(System.out::println);

		/* 練習問題
		 * ラップアラウンドしている事が確認できる。
		 * */
		System.out.println("random number of exercises");
        long m = (long) Math.pow(2, 48);
        generate(System.currentTimeMillis(), 25214903917L, 11, m).limit(100).forEach(System.out::println);

	}

	public static Stream<Long> generate(long seed, long a, long c, long m) {
		return Stream.iterate(seed, x -> (a * x + c) % m).skip(1);
	}

}
