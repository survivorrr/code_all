package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor{
/*
 * DispatcherServlet�յ�����֮�󣬻��ȵ���preHandle����������÷����ķ���ֵ��true��
 * ����������ã��������ֵ��false�����������á�
 * handler:����������������һ������
 * */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandler()");
		return true;
	}
	/*
	 * ������(Controller)�ķ����Ѿ�������ϣ���׼����������(ModelAndView����)���ظ�
	 * DispatcherServlet֮ǰִ��postHandle�����������ڸ÷������޸Ĵ�����
	 * */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle()");
	}
	/*
	 * ���ִ�еķ���
	 * ע�⣺ֻ�е�preHandle��������trueʱ���÷����Ż�ִ��
	 * ex:�Ǵ��������׳����쳣������дһ�������������������������׳����쳣
	 * */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion()");
	}
}
