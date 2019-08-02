package cn.itcast.demo3;

public class Computer {
	public void openComputer()
	{
		System.out.println("电脑打开");
	}
	
	public void closeComputer()
	{
		System.out.println("电脑关闭");
	}
	
	public void useUSB(USB usb)//体现多态
	{
		usb.open();//USB usb = new Mouse();USB usb = new KeyBoard();
		          // 父类 变量名 = new 子类()，变量名.方法名，调用的是子类的方法。
		usb.close();
	}
}
