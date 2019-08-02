package cn.itcast.demo4;

public class Maintainer extends Net{
	public Maintainer(String name,String id)
	{
		super(name,id);
	}
	public void work()
	{
		System.out.println(getName()+"...."+getId()+"....."+"维护部正在保持网络畅通");
	}

}
