package cn.itcast.demo01;

import java.util.Properties;
import java.util.Set;

public class PropertesDemo {
	public static void main(String[] args) {
		Properties pro = new Properties();
		pro.setProperty("a","1");
		pro.setProperty("b","2");
		pro.setProperty("c","3");
		System.out.println(pro);
		
		String value = pro.getProperty("c");
		System.out.println(value);
		
		Set<String> set = pro.stringPropertyNames();//�Ѽ����е����м��洢�����ϵ���
		for(String key : set){
			System.out.println(key+"..."+pro.getProperty(key));
		}
	}
}
