package cn.itcast.demo1;

public class Person {
	private String name;
	private int age;
	public Person(String name,int age)//	���캯��
	{
		this.name = name;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
}
