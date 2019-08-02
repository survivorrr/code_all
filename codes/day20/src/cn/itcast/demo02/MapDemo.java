package cn.itcast.demo02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "abc");
		map.put(2, "bcd");
		map.put(4, "xiaojiejie");
		
		Set<Map.Entry<Integer,String>> set = map.entrySet();
		Iterator<Map.Entry<Integer,String>> it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer,String> entry = it.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"...."+value);

			
			
		}
	}
}
