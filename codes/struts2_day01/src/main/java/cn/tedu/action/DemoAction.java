package cn.tedu.action;
/*
 * 
 * struts控制器的默认控制器方法 execute(执行)
 * 
 * */
public class DemoAction {
	/*
	 * 控制器方法，控制方法返回值是视图的id
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
