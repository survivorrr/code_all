package cn.itcast.demo5;

public abstract class Employee {
	private String name;
	private String ID;
	
	public Employee(){}
	
	public Employee(String name,String ID)
	{
		this.name = name;
		this.ID = ID;
	}
	
	public abstract void work();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
}
