package cn.itcast.demo02;

import java.util.HashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<Person>();
		set.add(new Person("a",10));
		set.add(new Person("a",10));
		set.add(new Person("a",10));
		set.add(new Person("b",11));
		set.add(new Person("b",9));
		System.out.println(set);
	}
}
