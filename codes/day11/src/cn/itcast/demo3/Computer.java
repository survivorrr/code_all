package cn.itcast.demo3;

public class Computer {
	public void openComputer()
	{
		System.out.println("���Դ�");
	}
	
	public void closeComputer()
	{
		System.out.println("���Թر�");
	}
	
	public void useUSB(USB usb)//���ֶ�̬
	{
		usb.open();//USB usb = new Mouse();USB usb = new KeyBoard();
		          // ���� ������ = new ����()��������.�����������õ�������ķ�����
		usb.close();
	}
}
