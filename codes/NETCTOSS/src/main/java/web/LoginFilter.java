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
		//有3个请求不需要过滤，排除它们
		String path = req.getServletPath();
		if("/toLogin.do".equals(path) || "/login.do".equals(path)
							|| "/createImg.do".equals(path)) {
			//若是上面三个路径之一，不用过滤，继续执行
			chain.doFilter(req, resp);
			return;
		}
		//从session中尝试获取账号
		HttpSession session = req.getSession();
		String adminCode = (String)session.getAttribute("adminCode");
		//根据账号判断用户是否登录，就是看session是否有值
		if(adminCode == null) {
			//未登录，重定向到登录页面
			resp.sendRedirect("/NETCTOSS/toLogin.do");
		}else {
			//已登录，请求继续执行
			chain.doFilter(req, resp);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
