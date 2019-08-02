package cn.itcast.demo01;

public class RegexDemo {
	public static void main(String[] args) {
		checkQQ();
		checkTel();
	}
	
	public static void checkQQ()
	{
		String str = "997207782";
		boolean a = str.matches("[1-9][0-9]{5,9}");
		System.out.println(a);
	}
	
	public static void checkTel()
	{
		String str = "15914506820";
		boolean a = str.matches("[1][3578][0-9]{9}");
		System.out.println(a);
	}
}
