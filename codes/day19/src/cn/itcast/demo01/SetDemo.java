package cn.itcast.demo01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("LiaoZhaoHui");
		set.add("yao");
		set.add("zhaoyige");
		set.add("haogongzuo");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}
