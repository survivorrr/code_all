package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter{
//�ر�tomcatʱ�Զ����ô˷���
	public void destroy() {
		System.out.println("����LogFilter");
	}
	//�÷����Ǵ�����ҵ��ķ���
/*
 * Filter�൱����Servlet�ǵĹܼң�tomcat�ڵ���Servlet֮ǰ�Ὣ�����ύ��Filter��
 * Filter��Ȩ�����������Ҳ��Ȩ��������ֹ��tomcat���ǵ���doFilter������Filterͳһ
 * ��������ģ�����ǰtomcat�ᴴ����request��response�����룬���������ͣ�RequestFacade��
 * ResponseFacade
 * 
 * */
	public void doFilter(ServletRequest request, 
						ServletResponse response, FilterChain chain)
						throws IOException, ServletException {
		System.out.println("��ǰ�����־");
		//������������ִ�� 
		chain.doFilter(request, response);//д����仰���ܵ�����ȥ����servlet
		System.out.println("�ں������־");
	}
//tomcat����ʱ���Զ�ʵ����Filter��Ȼ�������init()����ʼ��Filter��
//���ô˷���ʱ�ᴫ��config���ö����Filter��һ��һ�Ĺ�ϵ�����Ը�Filter
//Ԥ�ò���(web.xml)���ö����ServletConfig�÷���ȫһ��
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("��ʼ��LogFilter");
	}
}
