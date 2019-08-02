package cn.itcast.demo02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
	public static void main(String[] args) {
		HashMap<Person,String> map = new HashMap<Person,String>();
		map.put(new Person("张三",22), "北京");
		map.put(new Person("李四",23), "上海");
		map.put(new Person("王五",19), "广州");
		map.put(new Person("六六",66), "天津");
		
/*		//迭代器遍历
		Set<Map.Entry<Person,String>> set = map.entrySet();
		Iterator<Map.Entry<Person,String>> it = set.iterator();
		while(it.hasNext()){
			Map.Entry<Person, String> entry = it.next();
			Person key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"  "+value);
		}*/
		
		//增强for循环遍历
		for(Person key : map.keySet()){
			String value = map.get(key);
			System.out.println(key+"..."+value);
		}
		
		System.out.println("=======================");
		
		for(Map.Entry<Person, String> entry: map.entrySet()){
			System.out.println(entry.getKey()+"..."+entry.getValue());
		}
	}
}
