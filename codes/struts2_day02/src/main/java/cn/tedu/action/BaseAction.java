package cn.tedu.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 所有控制器的基类，用于封装常用的session  request等，用于提供给子类进行复用
 * 
 * ActionSupport 是  struts2 提供了Action基础类用于复用公共代码的类(比如里面有SUCCESS)
 * */
public abstract class BaseAction extends ActionSupport implements SessionAware,ApplicationAware,RequestAware{
	protected Map<String,Object> session;
	protected Map<String,Object> application;
	protected Map<String,Object> request;
	
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
	
	public void setApplication(Map<String,Object> application) {
		this.application = application;
	}
	
	public void setRequest(Map<String,Object> request) {
		this.request = request;
	}
}
