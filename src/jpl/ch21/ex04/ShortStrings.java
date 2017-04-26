package jpl.ch21.ex04;

import java.util.ListIterator;
import java.util.NoSuchElementException;


/* 練習問題 21.4 ShortStringを拡張すべきですか？
 * 拡張すべきでない。nextやpreviousといった並列した概念を違うレイヤーで継承するため。
 */
public class ShortStrings implements ListIterator<String> {

	private ListIterator<String> strings;
	private String nextShort;
	private String previousShort;

	private final int MAX_LEN;

	public ShortStrings(ListIterator<String> strings, int maxLen ) {
		this.MAX_LEN = maxLen;
		this.strings = strings;
		nextShort = null;
		previousShort = null;
	}

	@Override
	public void add(String str) {
		if(str.length() < MAX_LEN) {
			strings.add(str);
		}
	}

	@Override
	public boolean hasNext() {
		if(nextShort != null) {
			return true;
		}
		while(strings.hasNext()) {
			nextShort = strings.next();
			if(nextShort.length() < MAX_LEN) {
				return true;
			}
		}
		nextShort =  null;
		return false;
	}

	@Override
	public boolean hasPrevious() {
		if(previousShort != null) {
			return true;
		}
		while(strings.hasPrevious()) {
			previousShort = strings.previous();
			if(previousShort.length() < MAX_LEN) {
				return true;
			}
		}
		previousShort =  null;
		return false;
	}

	@Override
	public String next() {
		previousShort = null;
		if(nextShort == null && !hasNext()) {
			throw new NoSuchElementException();
		}
		String n = nextShort;
		nextShort = null;
		return n;
	}

	@Override
	public int nextIndex() {
		if(!strings.hasNext()) {
			return strings.nextIndex();
		}
		strings.next();
		int ret = strings.nextIndex() - 1;
		strings.previous();
		return ret;
	}

	@Override
	public String previous() {
		nextShort = null;
		if(previousShort == null && !hasPrevious()) {
			throw new NoSuchElementException();
		}
		String n = previousShort;
		previousShort = null;
		return n;
	}

	@Override
	public int previousIndex() {
		if(!strings.hasPrevious()) {
			return strings.previousIndex();
		}
		strings.previous();
		int ret = strings.previousIndex() + 1;
		strings.next();
		return ret;
	}

	@Override
	public void remove() {
		if(nextShort != null && previousShort != null) {
			throw new UnsupportedOperationException();
		}
		if(nextShort != null ) {
			previous();
			strings.remove();
			next();
		}
		if(previousShort != null ) {
			next();
			strings.remove();
			previous();
		}
	}

	@Override
	public void set(String str) {
		if(str.length() < MAX_LEN) {
			strings.add(str);
		}
	}

}
