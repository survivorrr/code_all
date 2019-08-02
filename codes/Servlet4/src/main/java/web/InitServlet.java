package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/*
 * ��Servlet������������ҵ��ֻ������tomcat����ʱ��ʼ������
 * һ��WEB��Ŀ����1-2��������Servlet
 * */
public class InitServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		//tomcat����ʱ�����ȴ���context��Ȼ���ٴ���Servlet
		ServletContext ctx = getServletContext();
		//����Ĭ��Ϊ0
		ctx.setAttribute("count", 0);
	}

}
