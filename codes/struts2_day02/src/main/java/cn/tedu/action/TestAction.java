package cn.tedu.action;

public class TestAction extends BaseAction {
	public String execute() {
		session.put("demo1", "Hello Session");
		request.put("demo2", "Hello Request");
		application.put("demo3", "Hello Application");
		return SUCCESS;
	}
}
