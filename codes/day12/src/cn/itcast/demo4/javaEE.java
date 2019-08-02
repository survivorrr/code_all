package cn.itcast.demo4;

public class javaEE extends Developer{
	
	public javaEE(String name,String id)
	{
		super(name,id);
	}
	public void work()
	{
		System.out.println(getName()+"...."+getId()+"....."+"javaEE工程师在开发淘宝");
	}
	
}
