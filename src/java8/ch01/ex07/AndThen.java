package java8.ch01.ex07;

public class AndThen {

	public static void main(String args[]) {
		andThen(
				() -> {
					for(int i = 0; i < 3; i++ ) {
						System.out.println("Hello");
					}
				},
				() -> {
					for(int i = 0; i < 3; i++ ) {
						System.out.println("Good Bye");
					}
				}
				).run();
	}

	private static Runnable andThen(Runnable first, Runnable second) {
		first.run();
		return second;
	}
}
