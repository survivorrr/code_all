package cn.tedu.action;

import java.io.Serializable;


/*
 * ��ģ���ࣺ���ڷ�װ�û������Ϣ
 * �����ڵ�¼��������ע�������������
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
