package cn.itcast.demo03;

public class Person {
	private String name;
	private String age;
	
	
	public Person(String name,String age)
	{
		this.name = name;
		this.age = age;
	}
	public String toString()  //��дtoString,�����ʹ�ӡ�����Ͳ��Ƕ���ĵ�ַ�ˣ����Ƕ���ĳ�Ա����
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
