package cn.itcast.demo03;

import java.util.ArrayList;

public class ArrayListPersonDemo {
	public static void main(String[] args) {
		ArrayList<Person> arr = new ArrayList<Person>();
		
		arr.add(new Person("zhangsan","20"));
		arr.add(new Person("lisi","22"));
		arr.add(new Person("wangwu","25"));
		
		for(int i = 0;i < arr.size();i++)
		{
		//   Person a = arr.get(i);
		   System.out.println(arr.get(i));
		//	System.out.println(a.getName()+"...."+a.getAge());
		}	
	}
}
