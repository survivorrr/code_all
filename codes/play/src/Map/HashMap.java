package Map;
/**
 * 这个程序感觉有问题
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K,V> implements Map{
	private Entry<K,V>[] table = null;
	private int size = 0;

	public HashMap() {
		table = new Entry[16];
	}
	
	@Override
	public Object put(Object key, Object value) {
		int index = hash(key);
		Entry<K,V> entry = table[index];
		if(entry == null) {
			table[index] = new Entry(key,value,null,index);
			size++;
		}else {
			table[index] = new Entry(key,value,entry,index);
		}
		return table[index].getValue();
	}
	
	public int hash(Object key) {
		int index = key.hashCode()%(16-1);
		return Math.abs(index);
	}

	@Override
	public Object get(Object key) {
		
		return null;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	class Entry<K,V> implements Map.Entry<K, V>{

		K k;
		V v;
		Entry<K,V> next;
		int hash;
		
		public Entry(K k,V v,Entry<K,V> next,int hash) {
			this.k = k;
			this.v = v;
			this.next = next;
			this.hash = hash;
		}
		
		@Override
		public K getKey() {
			
			return k;
		}

		@Override
		public V getValue() {
			
			return v;
		}
		
	}

}
