package java8.ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class OutNameThread {

	public static void main(String args[]) {
		String[] names = { "Patter", "Paul", "Mary" };

		{
			List<Runnable> runners = new ArrayList<>();

			/* use for each */
			for(String name: names) {
				runners.add(() -> System.out.println(name));
			}
			/* test */
			for(Runnable runner: runners) {
				runner.run();
			}
		}

		{
			List<Runnable> runners = new ArrayList<>();

			/* use counter */
			for(int i = 0;  i < names.length; i++ ) {
				/* finalの自動変数に入れないと、配列がfinal宣言されていないため、
				 * コンパイルエラー
				 */
				final String name = names[i];
				runners.add(() -> System.out.println(name));
			}
			/* test */
			for(Runnable runner: runners) {
				runner.run();
			}
		}
	}
}
