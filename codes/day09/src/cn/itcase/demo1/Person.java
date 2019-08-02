package cn.itcase.demo1;

public class Person {
	private int age;
	String name;
	public void setAge(int a)
	{
		if(a>200 || a <0)
		{
			age = 20;
		}
		else
		{
			age = a;
		}
	}
	public void speak()
	{
		System.out.println(name+"...."+age);
	}
}
