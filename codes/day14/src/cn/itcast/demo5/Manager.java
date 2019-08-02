package cn.itcast.demo5;

public class Manager extends Employee{
	private double jiangjin;
	
	public Manager(){}
	public Manager(String name,String ID,double jiangjin)
	{
		super(name,ID);
		this.jiangjin = jiangjin;
	}
	
	public void setJiangJin(double jiangjin)
	{
		this.jiangjin = jiangjin;
	}
	
	public double getJiangJin()
	{
		return jiangjin;
	}
	
	public void work()
	{
		System.out.println("哪个员工让顾客不满意我就扣谁的钱");
	}
}
