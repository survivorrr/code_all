package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter{
//关闭tomcat时自动调用此方法
	public void destroy() {
		System.out.println("销毁LogFilter");
	}
	//该方法是处理公共业务的方法
/*
 * Filter相当于是Servlet们的管家，tomcat在调用Servlet之前会将请求提交给Filter，
 * Filter有权让请求继续，也有权让请求终止。tomcat就是调用doFilter方法让Filter统一
 * 处理请求的，调用前tomcat会创建好request和response并传入，创建的类型：RequestFacade和
 * ResponseFacade
 * 
 * */
	public void doFilter(ServletRequest request, 
						ServletResponse response, FilterChain chain)
						throws IOException, ServletException {
		System.out.println("在前面记日志");
		//请求继续，向后执行 
		chain.doFilter(request, response);//写了这句话才能到继续去调用servlet
		System.out.println("在后面记日志");
	}
//tomcat启动时会自动实例化Filter，然后调用其init()来初始化Filter。
//调用此方法时会传入config，该对象和Filter是一对一的关系，可以给Filter
//预置参数(web.xml)。该对象和ServletConfig用法完全一样
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化LogFilter");
	}
}
