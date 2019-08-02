package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	//tomact����Servlet���߼���
	//LoginServlet s = new LoginServlet();
	//ServletConfig c = new ServletConfig();
	//c.��������();//��web.xml��������
	//s.init(c);
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		String maxOnline = config.getInitParameter("maxOnline");
		System.out.println(maxOnline);
	}
	
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp)
			throws ServletException, IOException {
		//��config����init()������Ǹ�
		ServletConfig config = getServletConfig();
		String maxOnline = config.getInitParameter("maxOnline");
		System.out.println(maxOnline);
		System.out.println("���ڵ�¼...");
	}
}
