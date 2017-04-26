package jpl.ch21.ex07;

import java.util.ArrayList;

public class MyStack<E> {
	/* 21.7 ArrayListを要素とすべき。
	 * ArrayListのIFを全て引き継ぐわけではなく、必要な機能のみをスタックの契約を持って、公開するため。
	 * */
	ArrayList<E> datas;

	public MyStack() {
		datas = new ArrayList<E>();
	}

	boolean empty() {
		return datas.isEmpty();
	}

	E peek() {
		int tailIndex = datas.size() - 1;
		return datas.get(tailIndex);
	}

	E pop()  {
		int tailIndex = datas.size() - 1;
		return datas.remove(tailIndex);
	}

	E push(E item) {
		datas.add(item);
		return item;
	}

	int	search(Object o) {
		for(int i = 1; i <= datas.size(); i++) {
			if(datas.get(i) .equals(o)) {
				return i;
			}
		}
		return -1;
	}
}
