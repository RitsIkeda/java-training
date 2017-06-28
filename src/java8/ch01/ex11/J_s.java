package java8.ch01.ex11;

public class J_s {

	public interface J_1 {
		void f();
	}

	public interface J_2 {
		static void f() {

		}
	}

	public interface J_3 {
		default void f() {
			System.out.println("default f");
		}
	}
}
