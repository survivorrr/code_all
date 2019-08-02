package cn.itcast.demo01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
		    String key = it.next();
			Integer value = map.get(key); 
			System.out.println(key+"...."+value);
			
//			Integer value = map.get(it.next()); 
//			System.out.println(it.next()+"...."+value);
			//不能这样写，否则打印出b....4，a....3
			//因为会在一次循环当中执行两次it.next()
		}
	}
}
