package java8.ch02.ex01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public final class CountLongContents {

	private static int count;

	public static void main(String[] args) throws IOException {
		String  contents = new String(Files.readAllBytes(Paths.get("src\\java8\\ch02\\ex01\\GettysburgAdress.txt")), StandardCharsets.UTF_8);
		countLongContentsSingle(contents,6);
		countLongContentsParallel(contents,6);
	}


	public static void countLongContentsSingle(String  contents , int threshold) {
		int count = 0;

		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		for(String word : words) {
			if(word.length() > threshold) {
				count++;
			}
		}
		System.out.println(count);
	}

	/* threadにより並列化してカウントするのは良い考えとはいえない。
	 * 単純な処理でも下記の記述が必要であり、複雑になれば同期やスレッドの安全性を全て実装者が担保しなくてはならない。
	 */
	public static void countLongContentsParallel(String  contents , int threshold) {
		count = 0;

		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		for(String word : words) {
			(new Thread(new Runnable() {
				@Override
				public void run() {
					if(word.length() > threshold) {
						count++;
					}
				}
			})).start();
		}

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);
	}

}
