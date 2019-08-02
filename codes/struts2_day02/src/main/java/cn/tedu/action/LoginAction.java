package cn.tedu.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction{
	
	
	//������������
	private String username;
	private String password;
	//���ղ�����bean���Ա���Ҫ�����ؼ���name����һ��
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String error;
	public String getError() {
		return error;
	}
	private String message;
	public String getMessage() {
		return message;
	}
	public String execute() {
		/*
		 * ActionContext��struts�д���ǰstruts2���������Ϣ
		 * */
		ActionContext ctx = ActionContext.getContext();
		/*
		 * Map���͵�session  ��������servlet  API  HttpSession����Servlet API
		 * ��϶ȵͣ��Ϳ��Խ����������޹صĲ��Ե����߲���
		 * 
		 * ���ߣ�����web��������ʹ�ã��������junit����
		 * 
		 * �ڵײ�struts2�����Ὣmap session�е���Ϣͬ����HttpSession��
		 * */
		Map<String,Object> session = ctx.getSession();
		session.put("loginName", "jerry");
		if("tom".equalsIgnoreCase(username) && "123".equals(password)) {
			message="��ӭTom�ٴλ���";
			return "success";
		}
		error="�û������������";
		return "login";
	}
}
