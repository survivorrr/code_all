package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, 
						ServletResponse response, FilterChain chain)
						throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//��3��������Ҫ���ˣ��ų�����
		String path = req.getServletPath();
		if("/toLogin.do".equals(path) || "/login.do".equals(path)
							|| "/createImg.do".equals(path)) {
			//������������·��֮һ�����ù��ˣ�����ִ��
			chain.doFilter(req, resp);
			return;
		}
		//��session�г��Ի�ȡ�˺�
		HttpSession session = req.getSession();
		String adminCode = (String)session.getAttribute("adminCode");
		//�����˺��ж��û��Ƿ��¼�����ǿ�session�Ƿ���ֵ
		if(adminCode == null) {
			//δ��¼���ض��򵽵�¼ҳ��
			resp.sendRedirect("/NETCTOSS/toLogin.do");
		}else {
			//�ѵ�¼���������ִ��
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
