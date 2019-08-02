package cn.itcast.demo4;

public class Test {
	public static void main(String[] args) {
		javaEE ee = new javaEE("zhangsan","007");
		ee.work();
		
		Maintainer main = new Maintainer("lisi","008");
		main.work();
	}
}
