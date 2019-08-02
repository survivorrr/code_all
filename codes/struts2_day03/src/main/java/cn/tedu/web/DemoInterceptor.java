package cn.tedu.web;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
@Component
public class DemoInterceptor implements Interceptor{
	
	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("开始");
		String val = "success";
		val = invocation.invoke();//调用后续的控制器
		System.out.println("结束");
		return val;
	}
}
