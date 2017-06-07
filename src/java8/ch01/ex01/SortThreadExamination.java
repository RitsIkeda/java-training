package java8.ch01.ex01;

import java.util.Arrays;

/*
 * 練習問題.1
 * コンパレータのコードは、sortを呼び出したスレッドで実行されることを確認した。
*/
public final class SortThreadExamination {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		String[] words = { "a", "mdedium", "tooooooooolong", "short" };
		Arrays.sort(words, (first, second)-> MyComparator.compare(first,second) );

	}

	private static class MyComparator {
		public static int compare(String first, String second) {
			 System.out.println(Thread.currentThread().getName());
			return Integer.compare(first.length(), second.length() );
		}
	}

}
