package java8.ch01.ex09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyCollection<T> implements Collection2<T> {

	private List<T> list = new ArrayList<T>();

	public static void main(String[] args) {
		MyCollection<String> strs = new MyCollection<String>();
		{
			String[] array ={ "Love", "the", "life", "you", "live.",
					"Live", "the", "life", "you", "love.", };
			for(String str : array ) {
				strs.add(str);
			}

			/* forEachIFメソッドの引数の中で、実行したい処理と、処理を行うためのの条件を記述できる */
			strs.forEachIF(
					System.out::println,
					e -> {
						return ( e.charAt(0) == 'l' || e.charAt(0) == 'L');
					}
					);
		}
	}

	@Override
	public boolean add(T arg0) {
		return list.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		return list.addAll(arg0);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean contains(Object arg0) {
		return list.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return list.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		return list.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return list.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return list.retainAll(arg0);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <E> E[] toArray(E[] arg0) {
		return list.toArray(arg0);
	}




}
