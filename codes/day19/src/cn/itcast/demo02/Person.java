package cn.itcast.demo02;

public class Person {
	private String name;
	private int age;
	
	public int hashCode()
	{
		return name.hashCode()+age*2;
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(obj instanceof Person)
		{
			Person p = (Person)obj;
			return name.equals(p.name) && p.age == age;
		}
	return false;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return age;
	}
	
	public Person(){}
	public Person(String name,int age)
	{
		super();
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		return name+"..."+age;
	}
}
