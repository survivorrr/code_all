package cn.tedu.action;
/*
 * 
 * struts��������Ĭ�Ͽ��������� execute(ִ��)
 * 
 * */
public class DemoAction {
	/*
	 * ���������������Ʒ�������ֵ����ͼ��id
	 * 
	 * */
	public String execute() {
		System.out.println("hello world");
		return "msg";
	}
	
	public String test() {
		System.out.println("test()");
		return "success";
	}
}
