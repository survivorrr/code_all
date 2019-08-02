package cn.itcast.demo03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
	public static void main(String[] args) {
		function();
	}
	
	public static void function(){
		List<String> list = new ArrayList<String>();
		list.add("gjkahdgojdfhg");
		list.add("yjktjyj");
		list.add("rtjryrth");
		list.add("bitetur");
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
	}
}
