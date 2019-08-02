package cn.itcase.demo2;

public class Person {
	int age;
	String name;
	
	public void setAge(int a)
	{
		age = a;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void speak()
	{
		System.out.println(name+"-----"+age);
	}
}
