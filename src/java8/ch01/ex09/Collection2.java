package java8.ch01.ex09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<T> extends Collection<T> {

	default void forEachIF( Consumer<T> action, Predicate<T> filter ) {
		for(Object o: toArray() ) {
			@SuppressWarnings("unchecked")
			T t = (T) o;
			if(filter.test(t)) {
				action.accept(t);
			}
		}
	}
}
