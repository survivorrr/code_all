package cn.itcast.demo02;

public class Person {
	private String name;
	private int age;
	
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	
	public Person(){
		super();
	}
	public Person(String name,int age){
		super();
		this.age =age;
		this.name = name;
	}
	
	public String toString(){
		return "Person"+"  "+name+"...."+age; 
	}
	
}
