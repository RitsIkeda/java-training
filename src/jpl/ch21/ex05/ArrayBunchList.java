package jpl.ch21.ex05;

import java.util.ListIterator;

public class ArrayBunchList<E> implements ListIterator<E> {

	private final E[][] arrays;
	private int size;
	private final int buffSize;
	private int index = -1;

	public ArrayBunchList(E[][] arrays) {
		this.arrays = arrays.clone();
		int s = 0;
		for(E[] array :arrays) {
			s += array.length;
		}
		size = s;
		buffSize = size;
	}

	@Override
	public void add(E value) {
		if(size >= buffSize) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		set(value);
		for(int i = index;  i < size; i++) {
			set(i + 1, get(i));
		}
		size++;
	}

	@Override
	public boolean hasNext() {
		return (index + 1) < size;
	}

	@Override
	public boolean hasPrevious() {
		return index > 0;
	}

	@Override
	public E next() {
		if(index + 1 >= size) {
			return null;
		}
		index++;
		return get(index);
	}

	@Override
	public int nextIndex() {
		return index + 1;
	}

	@Override
	public E previous() {
		if(index < 1) {
			return null;
		}
		index--;
		return get(index);
	}

	@Override
	public int previousIndex() {
		return index - 1;
	}

	@Override
	public void remove() {
		size--;
		for(int i = index;  i < size; i++) {
			set(i, get(i + 1));
		}
	}

	@Override
	public void set(E value) {
		if(index >= 0) {
			set(index,value);
		}
	}

	private E get(int index) {
		int off = 0;
		for(int i = 0; i < arrays.length; i++) {
			if(index < off + arrays[i].length) {
				return arrays[i][index - off];
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	private E set(int index, E value) {
		int off = 0;
		for(int i = 0; i < arrays.length; i++) {
			if(index < off + arrays[i].length) {
				E ret = arrays[i][index - off];
				arrays[i][index - off]  = value;
				return ret;
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

}
