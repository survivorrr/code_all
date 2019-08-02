package cn.itcast.demo03;

public class Person {
	private String name;
	private String age;
	
	
	public Person(String name,String age)
	{
		this.name = name;
		this.age = age;
	}
	public String toString()  //重写toString,这样就打印出来就不是对象的地址了，而是对象的成员数据
	{
		return name+"  "+age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setAge(String age)
	{
		this.age = age;
	}
	public String getAge()
	{
		return age;
	}
}
