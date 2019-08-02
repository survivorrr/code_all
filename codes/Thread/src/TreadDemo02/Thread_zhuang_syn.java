package TreadDemo02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 将集合或者map转成线程安全的
 * @author Administrator
 *
 */
public class Thread_zhuang_syn {
	public static void main(String[] args) {
		/**
		 * ArrayList和linkedList都是线程不安全的
		 */
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		//将给定集合转换为线程安全的集合
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		/**
		 * HashSet不是线程安全的
		 */
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		//将给定的set集合转换为线程安全的
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		/**
		 * HashMap也不是线程安全的
		 */
		
		/**
		 * API手册上有说明就算是线程安全的集合那么其中对于元素的操作，如：add、remove等方法都不与迭代器遍历做互斥，需要自行维护互斥关系
		 */
	}
}
