package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor{
/*
 * DispatcherServlet收到请求之后，会先调用preHandle方法。如果该方法的返回值是true，
 * 则继续向后调用，如果返回值是false，则不再向后调用。
 * handler:描述处理器方法的一个对象
 * */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandler()");
		return true;
	}
	/*
	 * 处理器(Controller)的方法已经处理完毕，正准备将处理结果(ModelAndView对象)返回给
	 * DispatcherServlet之前执行postHandle方法。可以在该方法里修改处理结果
	 * */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle()");
	}
	/*
	 * 最后执行的方法
	 * 注意：只有当preHandle方法返回true时，该方法才会执行
	 * ex:是处理器所抛出的异常，可以写一个拦截器。用来处理处理器所抛出的异常
	 * */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion()");
	}
}
