package java8.ch02.ex04;

import java.util.stream.Stream;

public class IntStream {


	public static void main(String[] args) {

		{
			int[] values = {1,4,9,16};
			/* streamの中身の方はint[]
			 * intはクラスでないため。
			 * */
			Stream.of(values).forEach(System.out::println);

		}
		{
			Integer[] values = {1,4,9,16};
			/* streamの中身がIntegerクラスとして認識される。*/
			Stream.of(values).forEach(System.out::println);
		}
	}



}
