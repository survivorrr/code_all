package cn.tedu.action;

import java.io.Serializable;


/*
 * 域模型类：用于封装用户相关信息
 * 可以在登录控制器和注册控制器中重用
 * */
public class UserInfo implements Serializable{
	
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", password=" + password + "]";
	}

	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
