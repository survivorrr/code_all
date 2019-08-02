package cn.itcast.demo5;

public class ChuShi extends Employee implements Server{
	public ChuShi()
	{}
	public ChuShi(String name,String ID)
	{
		super(name,ID);
	}
	
	public void work()
	{
		System.out.println("厨师在炒菜");
	}
	public void server()
	{
		System.out.println("厨师做菜加量");
	}
}
