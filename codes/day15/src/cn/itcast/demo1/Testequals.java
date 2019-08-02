package cn.itcast.demo1;

public class Testequals {
	public static void main(String[] args) {
		Person p1 = new Person("zhangsan",22);
		Person p2 = new Person("lisi",23);
		
		boolean a = p1.equals(p2);
		System.out.println(a);
	}
}
