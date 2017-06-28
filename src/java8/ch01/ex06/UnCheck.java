package java8.ch01.ex06;

public final class UnCheck {

	public static void main(String[] args) {
		new Thread( uncheck( ()->
		{
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();
	}

	public interface RunnableEx {
		 void run() throws Exception;
	}

	public static Runnable uncheck(RunnableEx r) {
		return () -> {
            try {
                r.run();
            } catch (Exception e) {
            	throw new RuntimeException(e);
            }
        };
	}


}
