package java8.ch01.ex11;

public class MultipleImplements {

	public static void main(String[] args) {
		(new AbstAbst()).f();
		(new AbstStatic()).f();
		(new AbstDefault()).f();
		(new StaticStatic()).callF();
		(new StaticDefault()).f();
		(new DefaulDefault()).f();
	}


	public static class AbstAbst implements I_s.I_1, J_s.J_1 {
		/* メソッドの衝突が起きているのでオーバーライド */
		@Override
		public void f() {
			System.out.println("Override");
		}
	}

	public static class AbstStatic implements  I_s.I_1, J_s.J_2 {
		/* staticでないメソッドが定義できてないので、オーバーライド */
		@Override
		public void f() {
			System.out.println("Override");
		}
	}

	public static class AbstDefault implements  I_s.I_1, J_s.J_3 {
		/* メソッドの衝突が起きているのでオーバーライド */
		@Override
		public void f() {
			J_s.J_3.super.f();
		}
	}

	/* staticメソッドはインターフェースから呼ぶ */
	public static class StaticStatic implements  I_s.I_2, J_s.J_2 {
		public void callF() {
			I_s.I_2.f();
		}
	}

	/* staticの方はインターフェースから呼び、デフォルトメソッドが呼ばれる */
	public static class StaticDefault implements  I_s.I_2, J_s.J_3 {


	}

	public static class DefaulDefault implements  I_s.I_3, J_s.J_3 {
		/* メソッドの衝突が起きているのでオーバーライド */
		@Override
		public void f() {
			I_s.I_3.super.f();
		}
	}



}
