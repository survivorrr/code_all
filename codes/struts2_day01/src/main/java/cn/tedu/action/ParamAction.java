package cn.tedu.action;
/*
 * struts2 ����"bean����"������������ݵĲ���
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
