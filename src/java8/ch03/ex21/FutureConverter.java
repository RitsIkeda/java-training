package java8.ch03.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class FutureConverter {

	public static <T, U> Future<U> map(Future<T> base, Function<T,U> converter) {
		return new Future<U>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return base.cancel(mayInterruptIfRunning);
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return converter.apply( base.get());
			}

			@Override
			public U get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException, TimeoutException {
				return converter.apply( base.get(timeout, unit));
			}

			@Override
			public boolean isCancelled() {
				return base.isCancelled();
			}

			@Override
			public boolean isDone() {
				return base.isDone();
			}

		};
	}
}
