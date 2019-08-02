package cn.itcast.demo02;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private int age;
	public void setAge(int age){
		this.age = age;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return this.age;
	}
	public String getName(){
		return this.name;
	}
	public Person(String name,int age){
		super();
		this.age = age;
		this.name = name;
	}
	public Person(){}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
