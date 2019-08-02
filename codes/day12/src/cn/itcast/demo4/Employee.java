package cn.itcast.demo4;

public abstract class Employee {
	private String name;
	private String id;
	
	public abstract void work();
	
	public Employee(String name,String id)
	{
		this.name = name;
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public String getId()
	{
		return id;
	}
}
