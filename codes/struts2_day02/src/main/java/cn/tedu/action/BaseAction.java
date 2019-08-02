package cn.tedu.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/*
 * ���п������Ļ��࣬���ڷ�װ���õ�session  request�ȣ������ṩ��������и���
 * 
 * ActionSupport ��  struts2 �ṩ��Action���������ڸ��ù����������(����������SUCCESS)
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
