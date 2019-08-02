package cn.tedu.action;
/*
 * struts2 利用"bean属性"接收浏览器传递的参数
 *  /demo/param?name=Tom
 * */


public class ParamAction {
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public String execute() {
		System.out.println(name);
		return "success";
	}
}
