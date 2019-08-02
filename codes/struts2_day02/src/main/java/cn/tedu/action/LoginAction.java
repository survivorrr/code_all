package cn.tedu.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction{
	
	
	//接收两个参数
	private String username;
	private String password;
	//接收参数的bean属性必须要与界面控件的name属性一致
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
		 * ActionContext在struts中代表当前struts2环境相关信息
		 * */
		ActionContext ctx = ActionContext.getContext();
		/*
		 * Map类型的session  不依赖于servlet  API  HttpSession（与Servlet API
		 * 耦合度低）就可以进行与容器无关的测试等离线操作
		 * 
		 * 离线：脱离web容器单独使用，比如进行junit测试
		 * 
		 * 在底层struts2容器会将map session中的信息同步到HttpSession中
		 * */
		Map<String,Object> session = ctx.getSession();
		session.put("loginName", "jerry");
		if("tom".equalsIgnoreCase(username) && "123".equals(password)) {
			message="欢迎Tom再次回来";
			return "success";
		}
		error="用户名或密码错误";
		return "login";
	}
}
