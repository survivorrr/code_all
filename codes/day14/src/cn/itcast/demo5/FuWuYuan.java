package cn.itcast.demo5;

public class FuWuYuan extends Employee implements Server{
	
	public FuWuYuan()
	{
		super();
	}
	
	public FuWuYuan(String name,String ID)
	{
		super(name,ID);
	}

	public void server()
	{
		System.out.println("服务员给顾客倒酒");
	}
	public void work()
	{
		System.out.println("服务员在工作");
	}
}
