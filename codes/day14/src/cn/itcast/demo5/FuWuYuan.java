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
		System.out.println("����Ա���˿͵���");
	}
	public void work()
	{
		System.out.println("����Ա�ڹ���");
	}
}
