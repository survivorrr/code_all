package cn.itcast.demo3;
/*
 * 多态的经典案例
 * 
 * */
public class Test {
	public static void main(String[] args)
	{
		Computer com = new Computer();
		com.openComputer();
		
		Mouse m = new Mouse();
		com.useUSB(m);
		com.useUSB(new KeyBoard());
		
		com.closeComputer();
	}
	
	
}
