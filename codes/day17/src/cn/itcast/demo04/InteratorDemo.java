package cn.itcast.demo04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class InteratorDemo {
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<String>();
		coll.add("134");
		coll.add("1345");
		coll.add("13456");
		
		Iterator<String> it = coll.iterator();
		boolean b = it.hasNext();
		System.out.println(b);
		
		while(it.hasNext())
		{
			String s = it.next();
			System.out.println(s);
		}
	}
}
