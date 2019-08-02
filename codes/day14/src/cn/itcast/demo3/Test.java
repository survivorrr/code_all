package cn.itcast.demo3;

public class Test {
	public static void main(String[] args)
	{
		Getperson getp = new Getperson();
		Person p = getp.get();
		p.eat();
		p.run();
	}
}
