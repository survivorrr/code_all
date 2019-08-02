package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GuolvFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, 
						ServletResponse response, FilterChain chain)
						throws IOException, ServletException {
		System.out.println("��ǰ��������д�");
		chain.doFilter(request, response);
		System.out.println("�ں���������д�");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(filterConfig.getInitParameter("city"));
	}

} 
