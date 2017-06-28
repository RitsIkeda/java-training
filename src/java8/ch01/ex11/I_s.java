package java8.ch01.ex11;

public class I_s {

	public interface I_1 {
		void f();
	}

	public interface I_2 {
		static void f() {
			System.out.println("static f");
		}
	}

	public interface I_3 {
		default void f() {
			System.out.println("default f");
		}
	}

}
