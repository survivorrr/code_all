package cn.tedu.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
/*
 * Struts2可以将session注入到实现SessionAware接口的Action对象中
 * */
public class LoginAction2 implements SessionAware{
	private Map<String,Object> session;
	public void setSession(Map<String,Object> session){
		this.session = session;
	}
	
	private UserInfo user;
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public UserInfo getUser() {
		return user;
	}
	
	private String message;
	public String getMessage() {
		return message;
	}

	public String execute() {
		session.put("loginName", "jerry");
		if("tom".equalsIgnoreCase(user.getName()) && "123".equals(user.getPassword())) {
			message="欢迎tom";
			return "success";
		}
		message="用户名密码错误";
		return "error";
	}
}
