package cn.itcast.demo01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class iteratorDemo {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		HashSet<Integer> set =  new HashSet<Integer>();
		
		arr.add("123");
		arr.add("456");
		
		set.add(789);
		
		
		iteratorFunction(arr);
		iteratorFunction(set);
		
	
	}
	
	public static void iteratorFunction(Collection<?> coll)
	{
		Iterator<?> it = coll.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
