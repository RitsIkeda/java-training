package jpl.ch17.ex03;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.nio.channels.IllegalSelectorException;
import java.util.HashMap;
import java.util.Map;

public final class ResourceManager {

	private static class ResourceImpl implements Resource {
		String key;
		boolean needsRelase = false;

		ResourceImpl(String key) {
			this.key = key;
			//外部リソースの設定
			needsRelase = true;
		}

		@Override
		public void use(Object key, Object... args) {
			if(!key.equals(this.key)){
				throw new IllegalArgumentException("wrong key");
			}
			//リソースの使用
		}

		@Override
		public void release() {
			if(needsRelase) {
				needsRelase = false;
				//リソースの開放
			}
		}
	}

	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread repear;
	boolean shutdown = false;

	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource >();
		repear = new ReparThread();

		//リソースの初期化...
	}

	public synchronized void shutdown() {
		if(!shutdown) {
			shutdown = true;
			repear.interrupt();
		}
	}

	public synchronized Resource getResource(String key) {
		if(shutdown) {
			throw new IllegalSelectorException();
		}
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref,res);
		return res;
	}

	class ReparThread extends Thread {
		public void run() {
			while(true) {
				try {
					Reference<?> ref = queue.remove();
					Resource res = null;
					synchronized (ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				}
				catch(InterruptedException e) {
					break;
				}
			}
		}

	}

}
