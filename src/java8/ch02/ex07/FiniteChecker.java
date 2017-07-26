package java8.ch02.ex07;

import java.util.stream.Stream;

public final class FiniteChecker {

	/* 練習問題 2.7
	 * 良い考えでない。無理やりメモリ破壊を起こすくらいしか検証手段がなく、
	 * パフォーマンス、安全性共に悪影響を及ぼす。
	 */
	public static void main(String[] args) {

		System.out.println(isFinite(Stream.generate(Math::random)));
		System.out.println(isFinite(Stream.generate(Math::random).limit(1000)));

	}

	public static <T> boolean isFinite(Stream<T> stream) {

		try {
			@SuppressWarnings("unused")
			Object[] array = stream.toArray();

		} catch (OutOfMemoryError e) { /* 無限ストリームならメモリ破壊を起こす。 */
			return false;
		}
		return true;
	}
}
